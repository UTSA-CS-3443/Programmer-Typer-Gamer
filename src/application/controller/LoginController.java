package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.model.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController implements EventHandler<ActionEvent> {
	
	@FXML
	private Label user0, user1, user2, user3;
	private LoginModel logModel;
	
	public LoginController() {
		super();
		this.logModel = new LoginModel();
		
		ArrayList<String> userArr = new ArrayList<String>();
		userArr = logModel.getNameArr();
		
//		this.user0.setText(userArr.get(0));
//		this.user1.setText(userArr.get(1));
//		this.user2.setText(userArr.get(2));
//		this.user3.setText(userArr.get(3));
	}

	//@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		logModel.update( b.getText() );
		
		Parent root = null;
		
		try {
			root = FXMLLoader.load(getClass().getResource("/application/view/Game.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene); 
		window.centerOnScreen();
		window.show();
		
	}
	
	public void game2(ActionEvent event) {
		
		
		Parent root = null;
		
		try {
			root = FXMLLoader.load(getClass().getResource("/application/view/GameTwo.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene); 
		window.centerOnScreen();
		window.show();
		
		
		
	}
	
	
	
}