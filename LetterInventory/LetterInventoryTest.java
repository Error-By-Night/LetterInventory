package LetterInventory;

public class LetterInventoryTest {
	
	private char intCast (int i) {
		char ch = (char)(i + 'a'); // try 'a' instead of 97
		
		return ch;
	}
	
	public static void main(String[] args) {
		LetterInventory li = new LetterInventory("bcd");
		li.set('a', 10);
		System.out.println(li.size());
	}
}
