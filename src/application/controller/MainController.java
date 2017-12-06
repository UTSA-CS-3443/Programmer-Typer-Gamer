package application.controller;

import java.awt.Button;
import java.io.File;
import java.util.Random;

import application.Main;
import application.model.GamemodeOne;
import application.model.WordReader;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage; 

/**
 * @author Team Garbage
 * This class runs all the beginning interactions when the game is launched and the difficulty selections. 
 */
public class MainController implements EventHandler<ActionEvent> {
	@FXML
	private Label status; 
	@FXML
	private TextField user; 
	@FXML
	private Label myMessage;
	@FXML
	private boolean start = true;
	//The variables that link to the radio buttons on the main screen
	@FXML
	private RadioButton easyBut;
	@FXML
	private RadioButton mediumBut;
	@FXML
	private RadioButton hardBut;
	@FXML
	private RadioButton oceanBut;
	@FXML
	private RadioButton cityBut;
	@FXML
	private RadioButton spaceBut;
	@FXML
	private CheckBox soundCheckBox;
	//Used to select what theme is used
	public static boolean gameModeOne = false;
	public static boolean gameModeTwo = false;
	public static boolean gameModeThree = false;
	//Used to set the spawn rate of the enemies
	public static double DIFFICULTY_VALUE;
	//Used to set up the music that is played 
	public Media sound;
	public MediaPlayer mediaPlayer;
	public boolean mediaBool;
	// Current background image
	@FXML
	private ImageView curImage;
	public static boolean soundFixer; //Used to fix a looping issue with the sound
	
	//G.B. lives global constants
		public static int lives = 3; //start with 3 lives
		
		//G.B. points global constants
	    public static int POINTS_PER_WORD;
	    public static float BONUS_MODIFIER = 0.2f; //amount by which bonus increases
	    
	    /**
	     * Current score
	     */
	    public static SimpleIntegerProperty score = new SimpleIntegerProperty();
	    /**
	     * How many points next correct letter is worth
	     */
	    public static float scoreModifier = 1.0f;
	
	
	/*
	 * if login successful, Main Menu opens. 
	 * 
	 * Notice: login screen remains open. We will have to close it after 
	 * "successful" login. 
	 * 
	 */
	
	public MainController() {
		super();
		// for potential mute button idea
//		this.mediaBool = true;
//		this.soundCheckBox = new CheckBox();
//		try {
//			if(soundFixer == false) {
//			String musicFile = "src/soundTrack/powerMove.mp3";
//			this.sound = new Media(new File(musicFile).toURI().toString());
//			this.mediaPlayer = new MediaPlayer(sound);
//			this.mediaPlayer.play();
//			soundFixer = true;
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 
	 * Pauses the audio or plays the audio
	 * potential mute button idea
	 */
//	public void soundCheck() {
//		if (this.mediaBool == true) {
//			this.mediaBool = false;
//			this.mediaPlayer.pause();
//		}
//		else {
//			this.mediaBool = true;
//			this.mediaPlayer.play();
//		}
//	}
	
	/**
	 * Changes to the ocean background when the theme radio button is selected
	 * @param event
	 * event that is passed in from the main view
	 */
	public void oceanViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/oceanGameBg.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	
	/**
	 * Changes to the city background when the theme radio button is selected
	 * @param event
	 * event that is passed in from the main view
	 */
	public void cityViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/City.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	/**
	 * Changes to the space background when the theme radio button is selected
	 * @param event
	 * event that is passed in from the main view
	 */
	public void spaceViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/nebula.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	
	/**
	 * 
	 * @param event
	 * event that is passed in from the main view
	 * @throws Exception
	 * any unexpected exception
	 */
	public void Login(ActionEvent event) throws Exception {
		// Sets difficulty values to easy
		if(easyBut.isSelected() == true) {
			WordReader.easy = true;
			WordReader.medium = false;
			WordReader.hard = false;
			POINTS_PER_WORD = 100;
		}
		// Sets the difficulty value to medium
		if(mediumBut.isSelected() == true) {
			WordReader.easy = false;
			WordReader.medium = true;
			WordReader.hard = false;
			POINTS_PER_WORD = 200;
		}
		// Sets the difficulty value to hard
		if(hardBut.isSelected() == true) {
			WordReader.easy = false;
			WordReader.medium = false;
			WordReader.hard = true;
			POINTS_PER_WORD = 300;
		}
		// Sets the theme values to the ocean setting
		if(oceanBut.isSelected() == true) {
			gameModeOne = true;
			gameModeTwo = false;
			gameModeThree = false;
		}
		// Sets the theme value to the city setting
		if(cityBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = true;
			gameModeThree = false;
		}
		//Sets the theme value to the space setting
		if(spaceBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = false;
			gameModeThree = true;
		}
		// Used to fix a bug where the lives wouldn't reset if you quit out of a game mode with lives missing.
		lives = 3;
		
//		// When transitioning to login screen, stop the audio
//		this.mediaBool = false;
//		this.mediaPlayer.pause();
		
		// Launches to the next scene.
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Login.fxml")); // Loads Main Menu fxml 
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene); 
		window.show();
	}

	/**
	 * handle method for processing buttons, but we used direct login button method
	 */
	@Override
	public void handle(ActionEvent arg0) {
	}
}


