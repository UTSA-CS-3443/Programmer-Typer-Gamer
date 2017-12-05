 package application.controller;

import java.io.IOException;

import application.model.GamemodeOne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * @author Team Garbage
 * 
 * GameController handles input from the game view and updates the
 * GamemodeOne model.
 */
public class GameController implements EventHandler<ActionEvent>{
	
	public static GamemodeOne mode;
	@FXML public Canvas canvas;
	@FXML public TextField wordField;
	
	@FXML public Label Score;
	
	@FXML public VBox pauseMenu;
	@FXML public Button resumeButton;
	@FXML public Button mainMenuButton;
	@FXML public Button quitButton;
	
	@FXML public VBox gameOverMenu;
	@FXML public Button tryAgainButton;
	@FXML public Button resetButton;
	@FXML public Button quit2Button;

	
	public GameController() {
		super();
	}
	
	public void initialize() {
		mode = new GamemodeOne(this);
	}

	/*
	 * Executes when the user presses enter after typing a word.
	 * Checks the enemies on the screen for the word typed,
	 * and updates the score.
	 * 
	 * @param event The input event given from the view.
	 */
	@Override
	public void handle(ActionEvent event) {
		 if(event.getSource() instanceof TextField) {
			 TextField field = (TextField)event.getSource();
			 mode.checkWord(field.getText());
			 field.clear();
			 
			 String str = String.valueOf(MainController.score.get());
			 Score.setText("SCORE: " + str);
		 } 
	}
	
	/*
	 * Handles the input from the game that isn't a word being typed.
	 * 
	 * @param event The input event from the game.
	 */
	public void onKeyPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.ESCAPE) {
			pause();
		}
	}
	
	/*
	 * Pauses the game and shows the pause menu.
	 */
	public void pause() {
		mode.setPaused(true);
		pauseMenu.setVisible(true);
		 
	}
	
	/*
	 * Hides the pause menu and unpauses the game.
	 */
	public void resume() {
		mode.setPaused(false);
		pauseMenu.setVisible(false);
	}
	
	/*
	 * Resets the game.
	 */
	public void retry() {
		gameOverMenu.setVisible(false);
		mode = new GamemodeOne(this);
	}
	
	/*
	 * Returns the user to the main menu.
	 */
	public void mainMenu() {
		Parent menuViewParent = null;
		try {
			menuViewParent = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Loads Main Menu fxml 
		Scene menuViewScene = new Scene(menuViewParent);
		
		Stage window = (Stage) canvas.getScene().getWindow();
		window.setScene(menuViewScene);
		window.show(); 
		
		//reset score and bonus modifier
		MainController.score.setValue(0);
		MainController.scoreModifier = 1.0f;
	}
	
	/*
	 * Clsoes the game.
	 */
	public void quit() {
		System.exit(0);
	}
	
	/*
	 * Executes when the player is out of lives. Ends the game.
	 */
	public void gameOver() {
		mode.setPaused(true);
		gameOverMenu.setVisible(true);
		
		//reset score and bonus modifier
		MainController.score.setValue(0);
		MainController.scoreModifier = 1.0f;
	}
}
