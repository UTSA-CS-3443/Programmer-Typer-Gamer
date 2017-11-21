package model;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GamemodeOne {
	
	private ArrayList<Shark> sharks;
	private GraphicsContext gc;
	
	public GamemodeOne(GraphicsContext gc) {
		this.gc = gc;
		sharks = new ArrayList<Shark>();
		sharks.add(new Shark(50, 50, "test"));
		
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				update();
				draw(gc);			
			}
			
		}.start();
	}
	
	public void setGC(GraphicsContext gc) {
		this.gc = gc;
	}
	
	public void checkWord(String input) {
		System.out.println("Looking for word " + input);
		for(Shark shark: sharks) {
			if(shark.getWord().toLowerCase().equals(input.toLowerCase())) {
				System.out.println("Found shark with word " + input);
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
		
		gc.fillText("test", 10, 10);
	}

}
