package application.controller;

import java.io.*;
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
	private ArrayList<Label> userArr;
	private LoginModel logModel;
	
	public LoginController() {
		super();
		this.logModel = new LoginModel();
		
		
		for (int i = 0; i < 4; i++) {
			String fileName = "src/userFiles/user" + i + ".txt";
			File userFile = new File(fileName);
				
			// init
			if (userFile.exists()) {
				break;
			}
			else if (!userFile.exists()) {
				try {
					userFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("user file is not initialized correctly");
			}
			
			// setting label names
			String line = null;
			try {
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            
	            if (bufferedReader.readLine() == null) {
	            	
	            	continue;
	            }

	            while((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            }   

	            // Always close files.
	            bufferedReader.close();         
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