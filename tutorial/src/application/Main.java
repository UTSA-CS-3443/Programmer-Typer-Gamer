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



public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		try {
		
		
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			
			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("My title B");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args); 		
	}
	
	
}
