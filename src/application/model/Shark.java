package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Shark {
	
	private double x, y, dx, dy;
	private String word;
	private Image image;
	private Image bubbleImg;
	private Image heartImg;
	private boolean status;
	
	public Shark(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = -1;
		this.dy = 0;
		this.image = new Image("/Images/shark.png");
		this.bubbleImg = new Image("/Images/bubbles.gif");
		this.heartImg = new Image("/Images/heart.png" , 50, 50, false, false);
		this.status = false;
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
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean change) {
		this.status = change;
	}
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
		gc.setFont(new Font("TimesRomen", 28));
		gc.fillText(word, x + (image.getWidth() / 3) - 40, y + (image.getHeight() / 2));
	}
	
	public void bubbles(GraphicsContext gc) {
		gc.drawImage(bubbleImg, x - 50, y - 20);
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
