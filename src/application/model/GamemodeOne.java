package application.model;

import java.util.concurrent.CopyOnWriteArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GamemodeOne {
	private int counter = 0;
	private CopyOnWriteArrayList<Shark> sharks;
	
	public int DIFFICULTY_VALUE = 500; //The value used to change the difficulty. 
	
	public GamemodeOne(GraphicsContext gc) {
		WordReader randomWord = new WordReader();
		sharks = new CopyOnWriteArrayList<Shark>();
		sharks.add(new Shark(1300, 50, WordReader.getRandomWord()));
		
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
		for(Shark shark: sharks) {
			if(shark.getWord().toLowerCase().equals(input.toLowerCase())) {
				System.out.println("Found shark with word " + input + ". Removing...");
				sharks.remove(shark);
			}
		}
	}
	
	public void update() {
		for(Shark shark: sharks) {
			shark.update();
		}
	}
	
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, 1280, 720);
		for(Shark shark: sharks) {
			shark.draw(gc);
		}
	}

}
