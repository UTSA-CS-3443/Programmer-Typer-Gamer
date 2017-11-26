package application.model;

import java.util.concurrent.CopyOnWriteArrayList;

import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

public class GamemodeTwo {
	private int counter = 0;
	private CopyOnWriteArrayList<Alien> aliens;
	public static double DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
	private boolean tru = false;
	
	//G.B.
	private int lives = 3; //start with 3 lives
	
	//G.B. points constants
    private static final int POINTS_PER_WORD = 100;
    private static final float BONUS_MODIFIER = 0.2f; //amount by which bonus increases

    /**
     * Current score
     */
    private SimpleIntegerProperty score = new SimpleIntegerProperty();
    /**
     * How many points next correct letter is worth
     */
    private float scoreModifier = 1.0f;

	
	public GamemodeTwo(GraphicsContext gc) {
		WordReader randomWord = new WordReader();
		aliens = new CopyOnWriteArrayList<Alien>();
		aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175, WordReader.getRandomWord()));
	
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				update();
				draw(gc);			
			}
			
		}.start();
	}
	
	public void checkWord(String input) {
		System.out.println("Looking for word " + input);
		for(Alien alien: aliens) {
			
			//if you get word correct
			if(alien.getWord().toLowerCase().equals(input.toLowerCase())) {
				System.out.println("Found shark with word " + input + ". Removing...");

				//aliens.remove(alien);
				tru = true;

			}
			System.out.println(score);
			System.out.println("scoreModifier " + scoreModifier); //G.B. score test
		}
	}

	
	public void update() {
		counter++;
		if(aliens.isEmpty() == false) {
			for(Alien alien: aliens) {
				if(alien.getY() > 500) { // (enemy reaches player) takes care of collision
					aliens.remove(alien);
					
					//G.B. enemy goes past player
					scoreModifier = 1.0f; //reset the Bonus
					System.out.println("scoreModifier " + scoreModifier); //G.B. score test
					
					//G.B. lives
					lives = lives - 1;
					if(lives <= 0) {
						lives = 0; //stops removing lives
					    //call fail state/game stop method
					}
					System.out.println("lives " + lives); //gb lives test
				}
				alien.update();
			}
		}
		else {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175 , WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
		}
		if(counter % Math.rint(DIFFICULTY_VALUE) == 0 ) {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -175 , WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
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
				
				if(i == 2) {
					aliens.remove(alien);
					tru = false; 
				}
			i++;
			}
		}
	}
}

