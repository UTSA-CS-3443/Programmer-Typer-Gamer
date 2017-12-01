package application.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import application.controller.MainController;

/**
 * 
 * @author Genaro Barrera
 * 
 * WordReader reads a line from either the easy, medium, or hard word banks. It adds the read word to an array list
 * (words) and then returns a random word from the file through the getRandomWord method.
 * Other random methods are also located in this class.
 *
 */

public class WordReader {

	// define constant which is our path to our word file (first / means relative path)
	
	private static final String easyfile = "/wordFiles/easy.txt";
	private static final String mediumfile = "/wordFiles/medium.txt";
	private static final String hardfile = "/wordFiles/hard.txt";
	
	//These should be global variables that could be accessed from other files
	public static boolean easy = false;
	public static boolean medium = false;
 	public static boolean hard = false; //should this be static?

	// ArrayList of strings which will be our words
	private static ArrayList<String> words = new ArrayList<String>();

	public WordReader() { // constructor
		
		//easy = true; //test boolean
		//medium = true;
		//hard = true;
		
		if(easy == true) {
		 try (InputStream in = getClass().getResourceAsStream(easyfile);  //use ResourceAsStream rather than static methods
	                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

	            String line = ""; //tempoary storage for each word
	            
	            //while line isn't null, add the line into the words ArrayList
	            while ((line = bf.readLine()) != null)
	                words.add(line);
	        }
	        catch (Exception e) {
	            System.out.println("Couldn't find/read file: " + easyfile);
	            System.out.println("Error message: " + e.getMessage());
	        }// (end of try catch)
		}//(end of if)
		
		else if(medium == true) {
			 try (InputStream in = getClass().getResourceAsStream(mediumfile);  //use ResourceAsStream rather than static methods
		                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

		            String line = ""; //tempoary storage for each word
		            
		            //while line isn't null, add the line into the words ArrayList
		            while ((line = bf.readLine()) != null)
		                words.add(line);
		        }
		        catch (Exception e) {
		            System.out.println("Couldn't find/read file: " + mediumfile);
		            System.out.println("Error message: " + e.getMessage());
		        }// (end of try catch)
			}//(end of if)
		
		else if(hard == true) {
			 try (InputStream in = getClass().getResourceAsStream(hardfile);  //use ResourceAsStream rather than static methods
		                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

		            String line = ""; //tempoary storage for each word
		            
		            //while line isn't null, add the line into the words ArrayList
		            while ((line = bf.readLine()) != null)
		                words.add(line);
		        }
		        catch (Exception e) {
		            System.out.println("Couldn't find/read file: " + hardfile);
		            System.out.println("Error message: " + e.getMessage());
		        }// (end of try catch)
			}//(end of if)
	    }// (constructor) Note: I believe this constructor loads all words into the words ArrayList at once

	/**
	 * returns a random word from the words ArrayList
	 * 
	 * @return words //a random word from the words array list
	 */
	public static String getRandomWord() {
		if (words.isEmpty())
			return "NO-DATA";
		// multiply Math.random by the size of words ArrayList should return a valid index of the list
		return words.get((int) (Math.random() * words.size()));
	}
	
	/**
	 * returns a spawn randomly located within the scene size
	 * It also makes sure it isn't spawned out of bounds or clipping the scene
	 * 
	 * @return spawn
	 */
	public static double getRandomSpawn() {
		Random rand = new Random(); 
		double spawn = rand.nextInt(451) + 25; 
		return spawn;
	}
	
	/**
	 * returns an alien spawn from the top instead of the right side of the scene, 
	 * makes sure it isn't out of bounds or clipping as well. 
	 * 
	 * @return
	 */
	public static double getRandomAlienSpawn() {
		Random rand = new Random();
		double spawn = rand.nextInt(850) + 200;
		return spawn;
	}
	
	/**
	 * selects a random enemy spawn rate for either of the difficulties
	 * 
	 */
	public static void getRandomTimer() {
		Random rand = new Random(System.currentTimeMillis());
		double interval = 1000;
		if(easy == true) {
			interval = rand.nextInt(400) + 800;
		}
		if(medium == true) {
			interval = rand.nextInt(150) + 600;
		}
		if(hard == true) {
			interval = rand.nextInt(200) + 300;
		}
		MainController.DIFFICULTY_VALUE = interval;
	}
}