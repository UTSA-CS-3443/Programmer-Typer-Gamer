package controller;

import java.awt.Button;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage; 

public class MainController {
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
	
	public void Login(ActionEvent event) throws Exception {
		//User login = "user"
		if(user.getText().equals("user")) {
			status.setText("Login Success");
			
			
			//New Stage object called secondaryStage 
			Stage secondaryStage = new Stage(); 
			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml")); // Loads Main Menu fxml 
			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("/model/application.css").toExternalForm()); // adds style from css
			secondaryStage.setTitle("Programmer-Typer-Gamer");
			secondaryStage.setScene(scene);
			secondaryStage.show();

		
		}else {
			status.setText("Login Failed");
		}
	}
	
}


