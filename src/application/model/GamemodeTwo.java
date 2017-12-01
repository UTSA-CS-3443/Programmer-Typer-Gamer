package application.model;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import application.controller.MainController;
import application.controller.GameTwoController;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *  @author Team Garbage
 *
 *
 */

public class GamemodeTwo {
	private GameTwoController controller;
	private int counter = 0;
	private CopyOnWriteArrayList<Alien> aliens;
	public static double DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
	private boolean tru = false;
	private boolean paused = false;
	private boolean gameOver = false;
	String musicFile = "src/soundTrack/explosion.mp3";     // For example

	Media sound2 = new Media(new File(musicFile).toURI().toString());
	MediaPlayer explosion = new MediaPlayer(sound2);

    /**
     * Current score
     */
    private SimpleIntegerProperty score = new SimpleIntegerProperty();
    /**
     * How many points next correct letter is worth
     */
    private float scoreModifier = 1.0f;

	
	public GamemodeTwo(GameTwoController controller) {
		this.controller = controller;
		WordReader randomWord = new WordReader();
		WordReader.getRandomTimer();
		aliens = new CopyOnWriteArrayList<Alien>();
		aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175, WordReader.getRandomWord()));

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
		for(Alien alien: aliens) {

			//if you get word correct
			if(alien.getWord().toLowerCase().equals(input.toLowerCase())) {

				//System.out.println("Found shark with word " + input + ". Removing...");


				//aliens.remove(alien);
				tru = true;

				//G.B. score
				MainController.score.set(MainController.score.get() + (int)(MainController.scoreModifier * MainController.POINTS_PER_WORD));
				MainController.scoreModifier += MainController.BONUS_MODIFIER;

				//if you enter the word wrong
			} else {
				MainController.scoreModifier = 1.0f; //reset the Bonus

			}
			System.out.println(MainController.score);
			System.out.println("scoreModifier " + MainController.scoreModifier); //G.B. score test

		}
	}


	public void update() {
		if(paused) return;
		
		counter++;
		if(aliens.isEmpty() == false) {
			for(Alien alien: aliens) {
				if(alien.getY() > 500) { // (enemy reaches player) takes care of collision
					aliens.remove(alien);

					//G.B. enemy goes past player
					MainController.scoreModifier = 1.0f; //reset the Bonus
					System.out.println("scoreModifier " + MainController.scoreModifier); //G.B. score test

					//G.B. lives


					MainController.lives = MainController.lives - 1;
					if(MainController.lives <= 0) {
						MainController.lives = 0; //stops removing lives
						gameOver();
					}
					System.out.println("lives " + MainController.lives); //gb lives test
				}
				alien.update();
			}
		}
		else {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175 , WordReader.getRandomWord()));
			counter = 1;
		}
		if(counter % Math.rint(MainController.DIFFICULTY_VALUE) == 0 ) {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175 , WordReader.getRandomWord()));
			WordReader.getRandomTimer();
			counter = 1;
		}
	}

	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		int i = 0;
		for(Alien alien: aliens) {
			alien.draw(gc);
			while(tru == true) {
				//add explosion
				alien.explosion(gc);
				explosion.play();

				if(i == 2) {
					aliens.remove(alien);
					tru = false; 
				}
				i++;
				explosion.stop();
			}
			
			if(MainController.lives == 3) {
				alien.heart1(gc);
				alien.heart2(gc);
				alien.heart3(gc);

			}
			
			if(MainController.lives == 2) {
				alien.heart1(gc);
				alien.heart2(gc);
			}
			
			if(MainController.lives == 1) {
				alien.heart1(gc);
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

