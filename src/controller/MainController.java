package controller;

import java.awt.Button;
import java.time.Duration;
import java.util.Random;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.GamemodeOne; 

public class MainController {
	@FXML
	private Label status; 
	@FXML
	private TextField user; 
	@FXML
	private Label myMessage;
	@FXML
	private boolean start = true; 
	@FXML
	public Canvas canvas;
	@FXML
	public TextField wordField;
	
	public GraphicsContext gc;
	public GamemodeOne gm;
	

	
	/*
	 * if login successful, Main Menu opens. 
	 * 
	 * Notice: login screen remains open. We will have to close it after 
	 * "successful" login. 
	 * 
	 */
	
	public void Login(ActionEvent event) throws Exception {
		//User login = "user"

			
			
			//New Stage object called secondaryStage 
			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml")); // Loads Main Menu fxml 
			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene); 
			window.show(); 


		
	
	}
	
	//GameStage
	public void Game(ActionEvent event) throws Exception {
		Parent gameViewParent = FXMLLoader.load(getClass().getResource("/view/GamemodeOne.fxml")); // Loads Main Menu fxml 
		Scene gameViewScene = new Scene(gameViewParent);
		
		gm = new GamemodeOne(((Canvas) gameViewScene.lookup("#canvas")).getGraphicsContext2D());
		System.out.println(gm);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(gameViewScene);
		window.show(); 
	}
	
	public void onEnter(ActionEvent event) {
		System.out.println(event);
		gm.checkWord("test");
	}
	
	public void Pause(ActionEvent event) throws Exception {		

		Parent pauseViewParent = FXMLLoader.load(getClass().getResource("/view/PauseMenu.fxml")); // Loads Main Menu fxml 
		Scene pauseViewScene = new Scene(pauseViewParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(pauseViewScene);
		window.show(); 
	}
	
	public void ChangeDifficulty(ActionEvent event) throws Exception {		

		Parent DiffViewParent = FXMLLoader.load(getClass().getResource("/view/ChangeDifficulty.fxml")); // Loads Main Menu fxml 
		Scene DiffViewScene = new Scene(DiffViewParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(DiffViewScene);
		window.show(); 
	}
}


