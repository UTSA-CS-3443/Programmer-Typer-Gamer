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
	private ArrayList<Label> userArr;
	private LoginModel logModel;
	
	
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
			
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}     
			
			// setting label names
			String line = null;
			try {
	            if (br.readLine() == null) {
	            	// already empty file
	            	continue;
	            }
	            else {
	            	while((line = br.readLine()) != null) {
	            		// while the file does have stuff inside
	            		// update
	            		// for each game mode
	            			// cumulative total score
	            			// how many times died
	            		// save these stats to global
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