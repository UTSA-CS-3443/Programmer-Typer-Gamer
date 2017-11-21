package application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController implements EventHandler<ActionEvent> {
	
	@FXML
	private Label output;
	private LoginController logCont;
	
	public LoginController() {
		super();
		//this.calc = new Calculator();
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		
		//this.calc.update( b.getText() );
		//this.output.setText( calc.getValue() );
		
	}
}