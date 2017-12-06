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


/**
 * 
 * @author Team Garbage
 * 
 * Shows the save states, and retrieves the user information from the save states.
 * Directs to the appropriate game mode.
 *
 */
public class LoginController implements EventHandler<ActionEvent> {
	
	@FXML
	private Label user0, user1, user2, user3;
	private LoginModel logModel;
	
	public static File curUser;
	public static int curDiff;
	public static int totScore;
	public static int totDeath;
	
	
	
	/**
	 * Constructor.
	 * Creates new user files if they are not in the local directory.
	 * If the user files exist, read in the information and set to global.
	 */
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
				
			// initial users creation
			if (!userFile.exists()) {
				try {
					userFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			Scanner sc = null;
			try {
				sc = new Scanner(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}     
			
			// setting label names
			String line = null;
			try {
	            if (!sc.hasNext()) {
	            	// already empty file, so continue the loop
	            	continue;
	            }
	            else {
	            	while(sc.hasNext()) {
	            		LoginController.curDiff = Integer.parseInt(sc.next());
	            		LoginController.totScore = Integer.parseInt(sc.next());
	            		LoginController.totDeath = Integer.parseInt(sc.next());
	            	}
	            }   
	        }
	        catch(Exception e) {
	            System.out.println("Unable to open file '" + fileName + "'");
	            e.printStackTrace();
	        }
		}
	}

	/**
	 * Changes the game modes
	 */
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		logModel.update( b.getText() );
		
		Parent root = null;
		
		try {
			if(MainController.gameModeOne == true) {
				root = FXMLLoader.load(getClass().getResource("/application/view/Game.fxml"));
			}
			if(MainController.gameModeTwo == true) {
				root = FXMLLoader.load(getClass().getResource("/application/view/GameTwo.fxml"));
			}
			if(MainController.gameModeThree == true) {
				root = FXMLLoader.load(getClass().getResource("/application/view/GameThree.fxml"));
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