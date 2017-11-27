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

public class MainController implements EventHandler<ActionEvent> {
	@FXML
	private Label status; 
	@FXML
	private TextField user; 
	@FXML
	private Label myMessage;
	@FXML
	private boolean start = true; 
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
	public static boolean gameModeOne = false;
	public static boolean gameModeTwo = false;
	public static boolean gameModeThree = false;
	private int easyNum = 1000;
	private int mediumNum = 750;
	private int hardNum = 500;
	public Media sound;
	public MediaPlayer mediaPlayer;
	public boolean mediaBool;
	@FXML
	private ImageView curImage;
	
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
		this.mediaBool = true;
		this.soundCheckBox = new CheckBox();
		try {
			String musicFile = "src/soundTrack/powerMove.mp3";
			this.sound = new Media(new File(musicFile).toURI().toString());
			this.mediaPlayer = new MediaPlayer(sound);
			this.mediaPlayer.play();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Override
	public void soundCheck(ActionEvent event) {
		if (this.mediaBool == true) {
			this.mediaBool = false;
			this.mediaPlayer.pause();
		}
		else {
			this.mediaBool = true;
			this.mediaPlayer.play();
		}
	}
	
	public void oceanViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/oceanGameBg.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	
	public void cityViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/City.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	
	public void spaceViewChg(ActionEvent event) {
		Image image = new Image(getClass().getResource("/Images/.jpg").toExternalForm());
		this.curImage.setImage(image);
	}
	
	public void Login(ActionEvent event) throws Exception {
		if(easyBut.isSelected() == true) {
			GamemodeOne.DIFFICULTY_VALUE = easyNum;
			WordReader.easy = true;
			WordReader.medium = false;
			WordReader.hard = false;
			POINTS_PER_WORD = 100;
		}
		if(mediumBut.isSelected() == true) {
			GamemodeOne.DIFFICULTY_VALUE = mediumNum;
			WordReader.easy = false;
			WordReader.medium = true;
			WordReader.hard = false;
			POINTS_PER_WORD = 200;
		}
		if(hardBut.isSelected() == true) {
			GamemodeOne.DIFFICULTY_VALUE = hardNum;
			WordReader.easy = false;
			WordReader.medium = false;
			WordReader.hard = true;
			POINTS_PER_WORD = 300;
		}
		if(oceanBut.isSelected() == true) {
			gameModeOne = true;
			gameModeTwo = false;
			gameModeThree = false;
		}
		if(cityBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = true;
			gameModeThree = false;
		}
		if(spaceBut.isSelected() == true) {
			gameModeOne = false;
			gameModeTwo = false;
			gameModeThree = true;
		}
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Login.fxml")); // Loads Main Menu fxml 
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); // adds style from css
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene); 
		window.show();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
//	//GameStage
//	public void Game(ActionEvent event) throws Exception {		
//
//		Parent gameViewParent = FXMLLoader.load(getClass().getResource("/view/Game.fxml")); // Loads Main Menu fxml 
//		Scene gameViewScene = new Scene(gameViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(gameViewScene);
//		window.show(); 
//	}
//	
//	public void Pause(ActionEvent event) throws Exception {		
//
//		Parent pauseViewParent = FXMLLoader.load(getClass().getResource("/view/PauseMenu.fxml")); // Loads Main Menu fxml 
//		Scene pauseViewScene = new Scene(pauseViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(pauseViewScene);
//		window.show(); 
//	}
//	
//	public void ChangeDifficulty(ActionEvent event) throws Exception {		
//
//		Parent DiffViewParent = FXMLLoader.load(getClass().getResource("/view/ChangeDifficulty.fxml")); // Loads Main Menu fxml 
//		Scene DiffViewScene = new Scene(DiffViewParent);
//		
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(DiffViewScene);
//		window.show(); 
//	}
}


