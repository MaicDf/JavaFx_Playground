package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {
	@FXML // inject values in the fxMl loader here. Es necesaria para acceder a elementos
			// privados del archivo FXML
	private Circle myCircle;
	private double x;
	private double y;

	public void up(ActionEvent e) {
		System.out.println("up");

		myCircle.setCenterY(y -= 5);
	}

	public void down(ActionEvent e) {
		System.out.println("down");
		myCircle.setCenterY(y += 5);
	}

	public void left(ActionEvent e) {
		System.out.println("left");
		myCircle.setCenterX(x -= 5);
	}

	public void right(ActionEvent e) {
		System.out.println("right");
		myCircle.setCenterX(x += 5);
	}

}
