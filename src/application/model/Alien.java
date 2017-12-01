package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


/**
 * @author Team Garbage
 * This class is for the creation, upkeep, and interactions of the alien objects
 */
public class Alien {
	private double x, y, dx, dy; //These are used for the position and the movement of the object
	private String word; //This holds the string attached to the object
	private Image image; //This is the image on the object
	private Image explo; //This is the explosion image 
	private Image heartImg; //This is the image of the lives
	private boolean status; //Creates a boolean used to delete the correct object

	
	/**
	 * @param x
	 * @param y
	 * @param word
	 * Constructor for the Alien object
	 */
	public Alien(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = 0;
		this.dy = 1;
		this.image = new Image("/Images/Alien.png"); 
		this.explo = new Image("/Images/explosion.png");
		this.heartImg = new Image("/Images/heart.png" , 50, 50, false, false);
		this.status = false;
	}
	
	/**
	 * @return x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @return word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the status boolean
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * @param change modifies the status boolean
	 */
	public void setStatus(boolean change) {
		this.status = change;
	}
	
	/**
	 * updates the x and y based on the dx and the dy values
	 */
	public void update() {
		x += dx;
		y += dy;
	}
	/**
	 * @param gc
	 * This draws the images with the given x and y.
	 */
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
		gc.setFont(new Font("TimesRomen", 28));
		//gc.setFill(Color.WHITE);
		gc.fillText(word, x + (image.getWidth() / 2)  - 50, y + (image.getHeight() / 2) + 10);
	}
	
	/**
	 * @param gc
	 * this draws the explosion at the correct location
	 */
	public void explosion(GraphicsContext gc) {
		gc.drawImage(explo, x - 150, y - 200);
	}
	
	
	//Three hearts for three lives. 
	/**
	 * @param gc
	 */
	public void heart1(GraphicsContext gc) {
		gc.drawImage(heartImg,5,5);
	}
	
	/**
	 * @param gc
	 */
	public void heart2(GraphicsContext gc) {
		gc.drawImage(heartImg,50,5);
	}
	
	/**
	 * @param gc
	 */
	public void heart3(GraphicsContext gc) {
		gc.drawImage(heartImg,95,5);
	}

}
