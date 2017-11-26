package application.controller;

import application.model.GamemodeTwo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GameTwoController implements EventHandler<ActionEvent>{
	
	private GamemodeTwo mode;
	@FXML
	public Canvas canvas;
	
	public GameTwoController() {
		super();
	}
	
	public void initialize() {
		mode = new GamemodeTwo(canvas.getGraphicsContext2D());
	}

	@Override
	public void handle(ActionEvent event) {
		 if(event.getSource() instanceof TextField) {
			 TextField field = (TextField)event.getSource();
			 mode.checkWord(field.getText());
			 field.clear();
		 } 
	}
}
