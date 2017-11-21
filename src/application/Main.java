package application;

import javafx.scene.control.Button; 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
//G.B. WordReader imports
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;

import controller.*;
import view.*;
import model.*;

/*
 * Starts Login screen, user enters "user" to login
 */

public class Main extends Application {
	
	//new block of WordReader lines
	private static WordReader wordReader = new WordReader();
	
	/**
	* The word to guess simple string property is a string which is an observable
	* bean, so you can bind to it's value useful for communication between ui(view)
	* and logic fields(model) properties allow you to not have to things manually,
    */
	
	private static SimpleStringProperty word = new SimpleStringProperty();
    //end block
	

	@Override
	public void start(Stage primaryStage) {
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Programmer-Typer-Gamer");
			primaryStage.setScene(scene);
			primaryStage.show();
				
			
		
		} catch(Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		//wordReader.hard = true; //test case// is this setting it true before or after it goes through the if statements in WordReader
		
		//new block of WordReader lines
		word.set(wordReader.getRandomWord().toUpperCase());
        System.out.println(word);
	     
		System.out.println(wordReader.hard); //hard variable value test//
		
		// make a simple compare using scanner to take the user's input
		Scanner scanner = new Scanner(System.in); //instead of system.in replace it with the file name
		System.out.println("type the word on the sharks: ");
		String typedWord = scanner.nextLine().toUpperCase();
		System.out.println("Your typed word is: " + typedWord);
		scanner.close(); 
		
		boolean match = false;
		
		if(word.getValue().equals(typedWord)) {
			match = true;
		}
		
		System.out.printf("match is: %s\n", match);
		//end of block
		
		launch(args); 
	}
}
