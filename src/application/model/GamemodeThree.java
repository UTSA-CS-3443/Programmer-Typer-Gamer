package application.model;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import application.controller.GameController;
import application.controller.GameThreeController;
import application.controller.MainController;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GamemodeThree {
	private GameThreeController controller;
	private int counter = 0;
	private CopyOnWriteArrayList<Asteroid> asteroids;
	private boolean paused = false;
	private boolean gameOver = false;
	
	//Sets up the sounds that happen when a shark dies
	String musicFile = "src/soundTrack/poof.mp3";     // For example
	Media sound1 = new Media(new File(musicFile).toURI().toString());
	MediaPlayer poof = new MediaPlayer(sound1);
	
	
	public GamemodeThree(GameThreeController controller) {
		this.controller = controller;
		WordReader randomWord = new WordReader();		
		WordReader.getRandomTimer();
		asteroids = new CopyOnWriteArrayList<Asteroid>();
		asteroids.add(new Asteroid(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
		
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
		for(Asteroid asteroid: asteroids) {
			if(asteroid.getWord().toLowerCase().equals(input.toLowerCase())) {
				asteroid.setStatus(true);
			}
		}
	}
	
	public void update() {
		if(paused) return;
		counter++;
		if(asteroids.isEmpty() == false) {
			for(Asteroid asteroid: asteroids) {
				if(asteroid.getX() < -300) { //shark left screen, lose life
					asteroids.remove(asteroid);
					
					//G.B. lives
					MainController.lives = MainController.lives - 1;
					if(MainController.lives <= 0) {
						MainController.lives = 0; //stops removing lives
						//call fail state/game stop method
					}
					
					if(MainController.lives <= 0) gameOver();
				}
				asteroid.update();
			}
		}
		else {
			asteroids.add(new Asteroid(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
			counter = 1;
		}
		if(counter % Math.rint(MainController.DIFFICULTY_VALUE) == 0 ) {
			asteroids.add(new Asteroid(1300, WordReader.getRandomSpawn(), WordReader.getRandomWord()));
			counter = 1;
			WordReader.getRandomTimer();
			}
	}
	
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		int i = 0;
		for(Asteroid asteroid: asteroids) {
			asteroid.draw(gc);
			while(asteroid.getStatus() == true) {
				//add explosion
				asteroid.explosion(gc);
				poof.play();
				
				
				if(i == 2) {
					asteroids.remove(asteroid);
					asteroid.setStatus(false); 
					
				}
			i++;
			poof.stop();
			}
			
			if(MainController.lives == 3) {
				asteroid.heart1(gc);
				asteroid.heart2(gc);
				asteroid.heart3(gc);

			}
			
			if(MainController.lives == 2) {
				asteroid.heart1(gc);
				asteroid.heart2(gc);
			}
			
			if(MainController.lives == 1) {
				asteroid.heart1(gc);
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
