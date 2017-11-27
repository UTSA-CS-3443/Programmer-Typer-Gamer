package application.model;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import application.controller.GameController;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GamemodeOne {
	private GameController controller;
	private int counter = 0, lives = 3;
	private CopyOnWriteArrayList<Shark> sharks;
	public static double DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
	private boolean tru = false;
	private boolean paused = false;
	private boolean gameOver = false;
	
	String musicFile = "src/soundTrack/bubbles.mp3";     // For example

	Media sound1 = new Media(new File(musicFile).toURI().toString());
	MediaPlayer bubbles = new MediaPlayer(sound1);
	
	
	public GamemodeOne(GameController controller) {
		this.controller = controller;
		WordReader randomWord = new WordReader();
		sharks = new CopyOnWriteArrayList<Shark>();
		sharks.add(new Shark(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
		
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				update();
				draw(controller.canvas.getGraphicsContext2D());			
			}
			
		}.start();
	}
	
	public void checkWord(String input) {
		//System.out.println("Looking for word " + input);
		for(Shark shark: sharks) {
			if(shark.getWord().toLowerCase().equals(input.toLowerCase())) {
				//System.out.println("Found shark with word " + input + ". Removing...");
				tru = true; 
			}
		}
	}
	
	public void update() {
		if(paused) return;
		counter++;
		if(sharks.isEmpty() == false) {
			for(Shark shark: sharks) {
				if(shark.getX() < -300) { //shark left screen, lose life
					sharks.remove(shark);
					lives--;
					
					if(lives <= 0) gameOver();
				}
				shark.update();
			}
		}
		else {
			sharks.add(new Shark(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
		}
		if(counter % Math.rint(DIFFICULTY_VALUE) == 0 ) {
			sharks.add(new Shark(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
		}
	}
	
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		int i = 0;
		for(Shark shark: sharks) {
			shark.draw(gc);
			while(tru == true) {
				//add explosion
				shark.bubbles(gc);
				bubbles.play();
				
				
				if(i == 2) {
					sharks.remove(shark);
					tru = false; 
					
				}
			i++;
			bubbles.stop();
			}
		}
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
		
	}
	
	public void gameOver() {
		gameOver = true;
		controller.gameOver();
	}

}
