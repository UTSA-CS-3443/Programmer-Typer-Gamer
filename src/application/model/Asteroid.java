package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Team Garbage
 * This class is for the creation, upkeep, and interaction of the Asteroid objects.
 */
public class Asteroid {
	private double x, y, dx, dy; //These are used for the position and the movement of the object
	private String word; //This holds the string attached to the object
	private Image image; //This is the image on the object
	private Image poof; //This is the poof image 
	private Image heartImg; //This is the image of the lives
	private boolean status; //Creates a boolean used to delete the correct object
	
	/**
	 * @param x
	 * @param y
	 * @param word
	 * The constructor for the Asteroid object
	 */
	public Asteroid(double x, double y, String word) {
		this.x = x;
		this.y = y;
		this.word = word;
		this.dx = -1;
		this.dy = 0;
		this.image = new Image("/Images/asteroid.png"); 
		this.poof = new Image("/Images/poof.png", 300, 300, false, false);
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
	 * Updates the x and y values using the dx and dy values
	 */
	public void update() {
		x += dx;
		y += dy;
	}
	
	/**
	 * @return status
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * @param change
	 * changes the status to the change value
	 */
	public void setStatus(boolean change) {
		this.status = change;
	}
	
	/**
	 * @param gc
	 * draws the Asteroid and the linked text
	 */
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
		gc.setFont(new Font("TimesRomen", 28));
		gc.setFill(Color.WHITE);
		gc.fillText(word, x + (image.getWidth() / 2)  - 60, y + (image.getHeight() / 2) + 10);
	}
	
	/**
	 * @param gc
	 * draws the poof when an Asteroid is destroyed
	 */
	public void explosion(GraphicsContext gc) {
		gc.drawImage(poof, x - 50, y - 70);
	}
	
	//The images that are used to show how many lives are left.
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