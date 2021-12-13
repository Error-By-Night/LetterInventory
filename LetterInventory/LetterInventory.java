package LetterInventory;

import java.util.*;

// Joey Kang
// TA: Effie Zheng
// The LetterInventory class represents an array of letters that can vary in size. The array can 
// only store lower case letters and is not case sensitive when reading letters. In addition, the 
// array cannot take in non-alphabetic characters.

public class LetterInventory {

	public static final int ALPHABET_LETTERS = 26;
	
	private int[] inventory;
	private int size;
	
	// post : constructs an empty array of default capacity
	public LetterInventory() {
		inventory = new int [ALPHABET_LETTERS];
	}
	
	// post : constructs an array inventory of a given string of letters, counts how many times 
	//		  that letter has occurred and puts the results in inventory and increases the size. 
	// 		  Letters in inventory are case insensitive
	public LetterInventory (String data) {
		this();
		for (int i = 0; i < data.length(); i++) {
			char letter = Character.toLowerCase(data.charAt(i));
			if(Character.isLetter(letter)) {
				inventory[letter - 'a']++; // ASCII Values, a = 97... z = 122
				size++;	
			}
		}
	}
	
	// post : returns current amount of elements in inventory
	public int size() {
		return size;
	}
	
	// post : casts char to int and returns num
	private int charCast (char c) {
		int num = Character.toLowerCase(c) - 'a';
		
		return num;
	}
	
	// post : casts given int to char and returns character
	private char intCast (int i) {
		char ch = (char)(i + 'a');
		
		return ch;
	}
	
	// pre : input are letters and not anything else, otherwise returns exception 	
	// post : returns the count of given letter in inventory
	public int get(char letter) {
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException("Input must be letters!");
		}
		return inventory[charCast(letter)];
	}
	
	// pre: makes sure letters are not numbers and are positive and not 0 (throws exception if are)
	// post: sets value in inventory 	
	public void set(char letter, int value) {
		if (!Character.isLetter(letter) || value < 0) {
			throw new IllegalArgumentException();
		}
		int index = charCast(letter);
		size += value - inventory[index];
		inventory[index] = value;	
	}
	
	// post : returns true if inventory is empty
	//		  otherwise returns false
	public boolean isEmpty() {
		return size == 0;
	}
	
	// post : creates a bracketed, String representation of inventory in alphabetical order
	// TODO: Fix toString
	public String toString() {
		String output = "[";
		
		for (int i = 0; i < ALPHABET_LETTERS; i++) {
			for (int j = 0; j < inventory[i]; j++) { // instead of inventory.length, maybe size?
				char letter = intCast(i);
				output += Character.toString(letter); 
			}
		}
		output += "]";
		return output; // += "]";
	}

	// post : adds two LetterInventory arrays together to create one combined LetterInventory 
	// 		  which is the result of the two strings added together
	public LetterInventory add(LetterInventory other) {
		LetterInventory sum = new LetterInventory("");
		
		for (int i = 0; i < ALPHABET_LETTERS; i++) {
			char ch = intCast(i);
			int amount = inventory[i] + other.get(ch);
			sum.set(ch, amount);
		}
		return sum;
	}
	
	// post : subtracts one LetterInventory from another to create new LetterInventory array with
	// 		  new values (sum, inventory, size, etc.) 
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory difference = new LetterInventory("");
	
		for (int i = 0; i < ALPHABET_LETTERS; i++) {
			char ch = intCast(i);
			int amount = inventory[i] - other.get(ch);
			if (amount < 0 ) {
				return null;
			}
			difference.set(ch, amount);
		}
		return difference;
	}
}
