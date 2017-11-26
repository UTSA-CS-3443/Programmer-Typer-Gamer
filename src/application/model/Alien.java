package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Alien {
	private double x, y, dx, dy;
	private String word;
	private Image image;
	private Image explo;
	
	public Alien(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = 0;
		this.dy = 1;
		this.image = new Image("/Images/Alien.png"); 
		this.explo = new Image("/Images/explosion.png");
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
		gc.drawImage(explo, x - 150, y - 200);
	}

}
