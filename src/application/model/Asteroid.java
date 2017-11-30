package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Asteroid {
	private double x, y, dx, dy;
	private String word;
	private Image image;
	private Image poof;
	private Image heartImg; 
	
	public Asteroid(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = -1;
		this.dy = 0;
		this.image = new Image("/Images/asteroid.png"); 
		this.poof = new Image("/Images/poof.png", 300, 300, false, false);
		this.heartImg = new Image("/Images/heart.png" , 50, 50, false, false);

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
		gc.fillText(word, x + (image.getWidth() / 2)  - 15, y + (image.getHeight() / 2) + 10);
	}
	
	public void explosion(GraphicsContext gc) {
		gc.drawImage(poof, x - 50, y - 70);
	}
	
	public void heart1(GraphicsContext gc) {
		gc.drawImage(heartImg,5,5);
	}
	
	public void heart2(GraphicsContext gc) {
		gc.drawImage(heartImg,50,5);
	}
	
	public void heart3(GraphicsContext gc) {
		gc.drawImage(heartImg,95,5);
	}

}