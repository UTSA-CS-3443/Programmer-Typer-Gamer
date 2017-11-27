package application.controller;

import java.awt.Button;
import java.util.Random;

import application.model.GamemodeOne;
import application.model.WordReader;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	@FXML
	private RadioButton easyBut;
	@FXML
	private RadioButton mediumBut;
	@FXML
	private RadioButton hardBut;
	@FXML
	private RadioButton oceanBut;
	@FXML
	private RadioButton cityBut;
	@FXML
	private RadioButton spaceBut;
	public static boolean gameModeOne = false;
	public static boolean gameModeTwo = false;
	public static boolean gameModeThree = false;
	public static double DIFFICULTY_VALUE;
	private int easyNum = 1000;
	private int mediumNum = 750;
	private int hardNum = 500;
	
	
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
		CheckBox box1 = new CheckBox();
	}
	
	public void Login(ActionEvent event) throws Exception {
		if(easyBut.isSelected() == true) {
			//DIFFICULTY_VALUE = easyNum;
			WordReader.easy = true;
			WordReader.medium = false;
			WordReader.hard = false;
		}
		if(mediumBut.isSelected() == true) {
			//DIFFICULTY_VALUE = mediumNum;
			WordReader.easy = false;
			WordReader.medium = true;
			WordReader.hard = false;
		}
		if(hardBut.isSelected() == true) {
			//DIFFICULTY_VALUE = hardNum;
			WordReader.easy = false;
			WordReader.medium = false;
			WordReader.hard = true;
		}
		if(oceanBut.isSelected() == true) {
			gameModeOne = true;
			gameModeTwo = false;
			gameModeThree = false;
		}
		if(cityBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = true;
			gameModeThree = false;
		}
		if(spaceBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = false;
			gameModeThree = true;
		}
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


