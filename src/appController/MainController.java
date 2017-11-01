package application;

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
	
	
	
	public void Login(ActionEvent event) throws Exception {
		//User login = "user"
		if(user.getText().equals("user")) {
			status.setText("Login Success");
			
			
			
			Stage secondaryStage = new Stage(); 
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setTitle("Programmer-Typer-Gamer");
			secondaryStage.setScene(scene);
			secondaryStage.show();

		
		}else {
			status.setText("Login Failed");
		}
	}


	
	public void generateRandom(ActionEvent event) {
		Random rand = new Random();
		int myRand = rand.nextInt(1000) + 1; 
	    myMessage.setText(Integer.toString(myRand)); 
	}
} 


