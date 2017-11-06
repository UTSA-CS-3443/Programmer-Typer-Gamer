package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordReader {
	
	//define constant which is our path to our word file (first / means relative path)
    private static final String fileName = "/resources/words.txt";

    //ArrayList of strings which will be our words
    private ArrayList<String> words = new ArrayList<String>();

    public WordReader() { //constructor
    	
    	/*
    	 * get class returns class of wordReader
    	 * then load ResourceAsStream, (will get our file and parse it into the InputStream)
    	 * place InputStream into InputStreamReader which is a new parser for the InputStream
    	 * Buffered Reader will make it readable for us line by line
    	 */
        try (InputStream in = getClass().getResourceAsStream(fileName);  //use ResourceAsStream rather than static methods
                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

            String line = ""; //tempoary storage for each word
            
            //while line isn't null, add the line into the words ArrayList
            while ((line = bf.readLine()) != null)
                words.add(line);
        }
        catch (Exception e) {
            System.out.println("Couldn't find/read file: " + fileName);
            System.out.println("Error message: " + e.getMessage());
        }
    }//Note: I believe this constructor loads all words into the words ArrayList at once

    /**
     * returns a random word from the words ArrayList
     * @return
     */
    public String getRandomWord() {
        if (words.isEmpty()) return "NO-DATA";
        //mult. Math.random by the size of words ArrayList should return a valid index of the list
        return words.get((int)(Math.random()*words.size()));
    }
}