package application.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class WordReader {

	// define constant which is our path to our word file (first / means relative path)
	
	private static final String easyfile = "/wordFiles/easy.txt";
	private static final String mediumfile = "/wordFiles/medium.txt";
	private static final String hardfile = "/wordFiles/hard.txt";
	
	//These should be global variables that could be accessed from other files
	public static boolean easy = false;
	public static boolean medium = false;
 	public boolean hard = false; //should this be static?

	// ArrayList of strings which will be our words
	private static ArrayList<String> words = new ArrayList<String>();

	public WordReader() { // constructor
		
		//easy = true; //test boolean
		//medium = true;
		hard = true;
		
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
	 * @return
	 */
	public static String getRandomWord() {
		if (words.isEmpty())
			return "NO-DATA";
		// multiply Math.random by the size of words ArrayList should return a valid index of the list
		return words.get((int) (Math.random() * words.size()));
	}
	
	public static double getRandomSpawn() {
		Random rand = new Random(); 
		double spawn = rand.nextInt(451) + 25; 
		return spawn;
	}
}