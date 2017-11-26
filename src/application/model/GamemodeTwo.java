package application.model;

import java.util.concurrent.CopyOnWriteArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GamemodeTwo {
	private int counter = 0;
	private CopyOnWriteArrayList<Alien> aliens;
	public static double DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
	
	public GamemodeTwo(GraphicsContext gc) {
		WordReader randomWord = new WordReader();
		aliens = new CopyOnWriteArrayList<Alien>();
		aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -50, WordReader.getRandomWord()));
	
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
			if(alien.getWord().toLowerCase().equals(input.toLowerCase())) {
				System.out.println("Found shark with word " + input + ". Removing...");
				aliens.remove(alien);
			}
		}
	}
	
	public void update() {
		counter++;
		if(aliens.isEmpty() == false) {
			for(Alien alien: aliens) {
				if(alien.getY() > 500) {
					aliens.remove(alien);
				}
				alien.update();
			}
		}
		else {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -50 , WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
		}
		if(counter % Math.rint(DIFFICULTY_VALUE) == 0 ) {
			aliens.add(new Alien(WordReader.getRandomAlienSpawn(), -50 , WordReader.getRandomWord()));
			counter = 1;
			DIFFICULTY_VALUE = DIFFICULTY_VALUE - .1;
		}
	}
	
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		for(Alien alien: aliens) {
			alien.draw(gc);
		}
	}

}
