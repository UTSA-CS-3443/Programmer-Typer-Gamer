package application.controller;

import java.io.IOException;

import application.model.GamemodeOne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class PauseController implements EventHandler<ActionEvent>{
	
	@FXML private Button resumeButton;
	@FXML private Button mainMenuButton;
	@FXML private Button quitButton;
	@FXML private CheckBox muteBox;

	@Override
	public void handle(ActionEvent event) {
		
	}
	
	public void resume(ActionEvent event) {

		GameController.mode.setPaused(true);
		
		Parent gameViewParent = null;
		try {
			gameViewParent = FXMLLoader.load(getClass().getResource("application/view/Game.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Loads Main Menu fxml 
		Scene gameViewScene = new Scene(gameViewParent);
		
		Stage window = (Stage) resumeButton.getScene().getWindow();
		window.setScene(gameViewScene);
		window.show(); 
	}
	
	public void mainMenu(ActionEvent event) {
		
	}
	
	public void quit(ActionEvent event) {
		
	}
	
	public void mute(ActionEvent event) {
		
	}

}
