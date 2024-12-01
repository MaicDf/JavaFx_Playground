package application;
	
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un fondo negro
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");

        // Crear una esfera central con gradiente
        Circle sphere = new Circle(100);
        sphere.setFill(new RadialGradient(
                0, 0, 0.5, 0.5, 0.5, true,
                javafx.scene.paint.CycleMethod.NO_CYCLE,
                new Stop(0, Color.DARKBLUE),
                new Stop(1, Color.BLACK)
        ));
        sphere.setEffect(new DropShadow(30, Color.BLUE));

        // Crear texto animado
        Text text = new Text("PlayStation 2");
        text.setFont(Font.font("Arial", 36));
        text.setFill(Color.LIGHTBLUE);
        text.setOpacity(0);

        // Añadir partículas animadas
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            Circle particle = new Circle(3, Color.LIGHTBLUE);
            particle.setTranslateX(random.nextInt(400) - 200); // Posición inicial aleatoria
            particle.setTranslateY(random.nextInt(400) - 200);

            // Animar las partículas con movimiento radial
            TranslateTransition moveParticle = new TranslateTransition(Duration.seconds(2 + random.nextDouble()), particle);
            moveParticle.setToX(random.nextInt(800) - 400); // Movimiento aleatorio
            moveParticle.setToY(random.nextInt(800) - 400);
            moveParticle.setCycleCount(TranslateTransition.INDEFINITE);
            moveParticle.setAutoReverse(true);
            moveParticle.play();

            root.getChildren().add(particle); // Añadir la partícula al fondo
        }

        // Animación de la esfera (escala)
        ScaleTransition scaleSphere = new ScaleTransition(Duration.seconds(3), sphere);
        scaleSphere.setFromX(0.5);
        scaleSphere.setFromY(0.5);
        scaleSphere.setToX(1.5);
        scaleSphere.setToY(1.5);

        // Animación del texto (fade-in)
        FadeTransition fadeText = new FadeTransition(Duration.seconds(2), text);
        fadeText.setFromValue(0);
        fadeText.setToValue(1);

        // Cambiar a la pantalla principal después de la animación
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> {
            // Cargar la pantalla principal
            StackPane mainRoot = new StackPane(new Text("¡Bienvenido al juego!"));
            mainRoot.setStyle("-fx-background-color: white;");
            primaryStage.setScene(new Scene(mainRoot, 800, 600));
        });

        // Combinar las animaciones
        SequentialTransition animation = new SequentialTransition(scaleSphere, fadeText, fadeOut);
        animation.play();

        // Añadir elementos principales al layout
        root.getChildren().addAll(sphere, text);

        // Crear la escena inicial
        Scene scene = new Scene(root, 800, 600);

        // Configurar la ventana principal
        primaryStage.setTitle("PS2 Style Loading");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
