package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shark {
	
	private double x, y, dx, dy;
	private String word;
	private Image image;
	
	public Shark(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = 1;
		this.dy = 0;
		this.image = new Image("/Images/shark.png");
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String getWord() {
		return word;
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
		gc.fillText(word, x, y);
	}

}
