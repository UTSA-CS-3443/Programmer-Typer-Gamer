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

import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/*
 * Starts Login screen, user enters "user" to login
 */

public class Main extends Application {
	

	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			String musicFile = "src/soundTrack/powerMove.mp3";     // For example

			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
			
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.setTitle("Keyboard Hero");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
}
