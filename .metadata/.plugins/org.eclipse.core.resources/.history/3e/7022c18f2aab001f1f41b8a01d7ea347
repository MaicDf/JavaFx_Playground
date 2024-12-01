package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	

	@Override
	public void start(Stage stage1) throws Exception {
		/* Stage stage1 = new Stage(); //->this way you create an a */
		Group root = new Group();// grupo de nodos
		Scene scene1 = new Scene(root,Color.ALICEBLUE);
		Image icon = new Image("Maybe a tatto.jfif");
		stage1.getIcons().add(icon);
		stage1.setTitle("Playground w00tw005");
		stage1.setScene(scene1);
		stage1.setWidth(400);
		stage1.setHeight(600);
		stage1.setX(0);
		stage1.setY(0);
		stage1.setFullScreen(true);
		stage1.setFullScreenExitHint("No Scape");
		stage1.setFullScreenExitKeyCombination(KeyCombination.valueOf("Q"));

		stage1.show();
	}
	public static void main(String[] args) {
		launch(args); // call start method
	}

}
/*
 Apuntes.
 Stage: Top level container
 Scene: next,smaller layer
 nodes: media content inside each scene. 
 */