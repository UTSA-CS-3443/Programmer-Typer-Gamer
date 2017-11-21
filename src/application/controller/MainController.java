package application.controller;

import java.awt.Button;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage; 

public class MainController implements EventHandler<ActionEvent> {
	@FXML
	private Label status; 
	@FXML
	private TextField user; 
	@FXML
	private Label myMessage;
	@FXML
	private boolean start = true; 

	
	/*
	 * if login successful, Main Menu opens. 
	 * 
	 * Notice: login screen remains open. We will have to close it after 
	 * "successful" login. 
	 * 
	 */
	
	public MainController() {
		super();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// handler
	}
	
	public void Login(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Login.fxml")); // Loads Main Menu fxml 
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene); 
		window.show();
	}
	
//	//GameStage
//	public void Game(ActionEvent event) throws Exception {		
//
//		Parent gameViewParent = FXMLLoader.load(getClass().getResource("/view/Game.fxml")); // Loads Main Menu fxml 
//		Scene gameViewScene = new Scene(gameViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(gameViewScene);
//		window.show(); 
//	}
//	
//	public void Pause(ActionEvent event) throws Exception {		
//
//		Parent pauseViewParent = FXMLLoader.load(getClass().getResource("/view/PauseMenu.fxml")); // Loads Main Menu fxml 
//		Scene pauseViewScene = new Scene(pauseViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(pauseViewScene);
//		window.show(); 
//	}
//	
//	public void ChangeDifficulty(ActionEvent event) throws Exception {		
//
//		Parent DiffViewParent = FXMLLoader.load(getClass().getResource("/view/ChangeDifficulty.fxml")); // Loads Main Menu fxml 
//		Scene DiffViewScene = new Scene(DiffViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(DiffViewScene);
//		window.show(); 
//	}
}

