package appController;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label; 

public class MainController {
	
	@FXML
	private Label myMessage; 
	public void generateRandom(ActionEvent event) {
		Random rand = new Random();
		int myRand = rand.nextInt(1000) + 1; 
	    myMessage.setText(Integer.toString(myRand)); 
	}
} 


