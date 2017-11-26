package application.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
	private ArrayList<Label> userArr;
	private LoginModel logModel;
	
	public LoginController() {
		super();
		this.logModel = new LoginModel();
		
		user0 = new Label();
		user1 = new Label();
		user2 = new Label();
		user3 = new Label();
		
		for (int i = 0; i < 4; i++) {
			String fileName = "src/userFiles/user" + i + ".txt";
			File userFile = new File(fileName);
				
			// init
			if (!userFile.exists()) {
				try {
					userFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// setting label names
			String line = null;
			try {
	            Scanner sc = new Scanner(userFile);
	            
	            if (!sc.hasNextLine()) {
	            	if (i == 0) {
	            		// update
	            	}
	            	if (i == 1) {
	            		// update
	            	}
	            	if (i == 2) {
	            		// update
	            	}
	            	if (i == 3) {
	            		// update
	            	}
	            }
	            else {
	            	while((line = sc.nextLine()) != null) {
	            		// while the file does have stuff inside
	            		// update
	            	}
	            }   
       
	        }
	        catch(FileNotFoundException e) {
	            System.out.println("Unable to open file '" + fileName + "'");
	            e.printStackTrace();
	        }
	        catch(IOException e) {
	            System.out.println("Error reading file '" + fileName + "'");
	            e.printStackTrace();
	        }
			
			
		}
		
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		logModel.update( b.getText() );
		
		Parent root = null;
		
		try {
			if(MainController.gameModeOne == true) {
				System.out.println("Does it get in the first if statement");
				root = FXMLLoader.load(getClass().getResource("/application/view/Game.fxml"));
			}
			if(MainController.gameModeTwo == true) {
				root = FXMLLoader.load(getClass().getResource("/application/view/GameTwo.fxml"));
			}
			if(MainController.gameModeThree == true) {
				//Add code to launch Game mode three when added. 
				//root = FXMLLoader.load(getClass().getResource("/application/view/GameThree.fxml"));
			}
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