package application.controller;

import application.model.GamemodeOne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

public class GameController implements EventHandler<ActionEvent>{
	
	private GamemodeOne mode;
	@FXML
	public Canvas canvas;
	
	public GameController() {
		super();
	}
	
	public void initialize() {
		mode = new GamemodeOne(canvas.getGraphicsContext2D());
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
