package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

/**
 * @author Team Garbage
 * This class is for the creation upkeep and interactions of the sharks object.
 */
public class Shark {
	
	private double x, y, dx, dy; //These are used for the position and the movement of the object
	private String word; //This holds the string attached to the object
	private Image image; //This is the image on the object
	private Image bubbleImg; //This is the bubble image 
	private Image heartImg; //This is the image of the lives
	private boolean status; //Creates a boolean used to delete the correct object
	
	/**
	 * @param x
	 * @param y
	 * @param word
	 * The constructor for the Shark Object
	 */
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
	 * @return status
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * @param change
	 * sets the status boolean to what change is
	 */
	public void setStatus(boolean change) {
		this.status = change;
	}
	/**
	 * updates the x and the y based on the values of dx and dy
	 */
	public void update() {
		x += dx;
		y += dy;
	}
	
	/**
	 * @param gc
	 * draws the shark and text that is linked to it
	 */
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
		gc.setFont(new Font("TimesRomen", 28));
		gc.fillText(word, x + (image.getWidth() / 3) - 40, y + (image.getHeight() / 2));
	}
	
	/**
	 * @param gc
	 * draws the bubbles which are used on shark death
	 */
	public void bubbles(GraphicsContext gc) {
		gc.drawImage(bubbleImg, x - 50, y - 20);
	}
	
	//The lives images
	
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
