package controller;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation {
	
	
	
	public static void Move(Stage secondaryStage) {
		
	Circle cir = new Circle(); 
	cir.setFill(Color.BLACK);
	cir.setRadius(30);
	cir.setLayoutX(550);
	cir.setLayoutY(50);
	
	TranslateTransition transition = new TranslateTransition(); 
	transition.setDuration(Duration.seconds(3));
	transition.setToX(-650);
	transition.setAutoReverse(true);
	transition.setCycleCount(javafx.animation.Animation.INDEFINITE);
	transition.setNode(cir);
	transition.play(); 
	
	Pane root = new Pane(); 
	root.getChildren().add(cir);
	Scene scene = new Scene(root, 600,400); 
	secondaryStage.setTitle("Under Water Typer");
	secondaryStage.setScene(scene);
	secondaryStage.show(); 
	
	}

}
