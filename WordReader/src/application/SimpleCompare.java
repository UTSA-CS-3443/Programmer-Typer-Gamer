package application;

import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;

public class SimpleCompare {
	private static WordReader wordReader = new WordReader();

	/**
	 * The word to guess simple string property is a string which is an observable
	 * bean, so you can bind to it's value useful for communication between ui(view)
	 * and logic fields(model) properties allow you to not have to things manually,
	 */
	private static SimpleStringProperty word = new SimpleStringProperty();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		word.set(wordReader.getRandomWord().toUpperCase());

		System.out.println(word);
		
		// make a simple compare using scanner to take the user's input
		Scanner scanner = new Scanner(System.in);
		System.out.println("type the word on the sharks: ");
		String typedWord = scanner.nextLine().toUpperCase();
		System.out.println("Your typed word is: " + typedWord);
		scanner.close(); 
		
		boolean match = false;
		
		if(word.getValue().equals(typedWord)) {
			match = true;
		}
		
		System.out.printf("match is: %s\n", match);
		
	}
}
