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
 * @author Team Garbage
 * 
 * This class is the model code for GamemodeTwo
 * GamemodeTwo runs the major interactions between the player, the enemies, and the game
 * methods in this class keep track of lives, score, whether enemies needs to be spawned or removed, and
 * whether the game is playable, paused, or has ended   
 *
 */
public class GamemodeTwo {
	private GameTwoController controller;
	private int counter = 0;
	private CopyOnWriteArrayList<Alien> aliens;
	public static double DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
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

	
	public GamemodeTwo(GameTwoController controller) { //constructor
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

	/**
	 * checkWord checks whether the word the player has typed matches with the words on the enemies. 
	 * If it does it sets the boolean variable tru to true, it increases the players score, and it adds a bonus 
	 * to the scoreModifier.
	 * Else the scoreModifier is reset so a bonus score isn't applied to missed words
	 * 
	 * @param input //the word the player types
	 */
	public void checkWord(String input) {
		//System.out.println("Looking for word " + input);
		for(Alien alien: aliens) {

			//if you get word correct
			if(alien.getWord().toLowerCase().equals(input.toLowerCase())) {
				alien.setStatus(true);
				//G.B. score
				MainController.score.set(MainController.score.get() + (int)(MainController.scoreModifier * MainController.POINTS_PER_WORD));
				MainController.scoreModifier += MainController.BONUS_MODIFIER;

				//if you enter the word wrong
			} else {
				MainController.scoreModifier = 1.0f; //reset the Bonus
			}

		}
	}

	/**
	 * update tracks whether an enemy has gone past the player
	 * if so the player looses a life and the scoreModifier bonus is reset
	 * if lives decrease down to 0 the gameOver method is called
	 * if no sharks are on screen a shark is spawned
	 * also difficulty values are updated here
	 * 
	 */
	public void update() {
		if(paused) return;
		
		counter++;
		if(aliens.isEmpty() == false) {
			for(Alien alien: aliens) {
				if(alien.getY() > 500) { // (enemy reaches player) takes care of collision
					aliens.remove(alien);

					//G.B. enemy goes past player
					MainController.scoreModifier = 1.0f; //reset the Bonus
					//System.out.println("scoreModifier " + MainController.scoreModifier); //G.B. score test

					//G.B. lives
					MainController.lives = MainController.lives - 1;
					if(MainController.lives <= 0) {
						MainController.lives = 0; //stops removing lives
						gameOver();
					}
					//System.out.println("lives " + MainController.lives); //gb lives test
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

	/**
	 * draws the enemies and adds death effects when an enemy is removed
	 * once an enemy has been removed, tru is set back to false
	 * lives are also drawn in this method, number of hearts drawn depend on the number of lives the player has  
	 * 
	 * @param gc
	 */
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		int i = 0;
		for(Alien alien: aliens) {
			alien.draw(gc);
			while(alien.getStatus() == true) {
				//add explosion
				alien.explosion(gc);
				explosion.play();

				if(i == 2) {
					aliens.remove(alien);
					alien.setStatus(false); 
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
	
	/**
	 * if set to true, this method pauses the game
	 * 
	 * @param paused
	 */
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	/**
	 * if set to true, this method ends the game
	 * 
	 */
	public void gameOver() {
		gameOver = true;
		controller.gameOver();
	}
}

