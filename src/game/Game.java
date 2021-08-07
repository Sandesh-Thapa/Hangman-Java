package game;

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class Game {
	private int availableTry = 6;
	private String [] wordsArray = {"education", "java"};
	private String word;
	private HashSet<Character> wordChar= new HashSet<Character>();
	private HashSet<Character> correctChar = new HashSet<Character>();
	private HashSet<Character> guessedChar = new HashSet<Character>();
	private HashSet<Character> wrongChar = new HashSet<Character>();
	
	public void startGame() {
		Scanner scan = new Scanner(System.in);
		initGame();
		while (this.availableTry > 0) {
			System.out.println("Type 'quit' to quit the game ...");
			System.out.print("Guessed Words: ");
			displayGuess();
	
			System.out.println();
			generateSpaces();
			System.out.println();
			
			System.out.println("Guess the word: ");
			String choice = scan.next();
			System.out.println();
			choice.toLowerCase();
			
			if (choice == "quit") {
				break;
			}else if (choice.length() > 1) {
				System.out.println("Enter only one character at a time !!!");
			}else {
				Character c = choice.charAt(0);
				boolean checkWin = checkTry(c);
				if(checkWin) {
					break;
				}
			}
		}
	}
	
	public void initGame() {
		resetGame();
		
		Random r = new Random();
		int wordPos = r.nextInt(this.wordsArray.length);
		this.word = this.wordsArray[wordPos];
		
		for(int i=0; i<this.word.length(); i++) {
			wordChar.add(this.word.charAt(i));
		}
		
		//System.out.println(this.word);
	}
	
	public void generateSpaces() {
		for(int i=0; i<this.word.length(); i++) {
			if (this.correctChar.contains(this.word.charAt(i))) {
				System.out.print(this.word.charAt(i));
				System.out.print("  ");
			}else {
				System.out.print("_");
				System.out.print("  ");
			}
		}
	}
	
	public boolean checkTry(Character c) {	
		boolean check = false;
		if (this.wordChar.contains(c) && !this.guessedChar.contains(c)) { // check for correct guess
			this.correctChar.add(c);
			this.guessedChar.add(c);
			System.out.println("Correct guess ...");
			System.out.println();
			displayHangman();
			System.out.println();
			
			if (this.wordChar.size() == this.correctChar.size()) {
				System.out.println("Congratulations !! You guessed it all right !!");
				generateSpaces();
				check = true;
				return check;
			}
			
		}else if (this.guessedChar.contains(c) || this.wrongChar.contains(c)) {
			System.out.println("Letter '"+c+"' guessed already !!!");
			System.out.println();
			displayHangman();
			System.out.println();
		}else {
			System.out.println("Oops! wrong guess !!!");
			this.guessedChar.add(c);
			decreaseTry();
			System.out.println();
			displayHangman();
			System.out.println();
		}
		return check;
	}
	
	public void decreaseTry() {
		this.availableTry--;
	}
	
	public void resetGame() {
		this.availableTry = 6;
		this.wordChar.clear();
		this.correctChar.clear();
		this.guessedChar.clear();
		this.wrongChar.clear();
		System.out.println();
		displayHangman();
		System.out.println();
	}
	
	public void displayGuess() {
		System.out.println();
		for(Character c : this.guessedChar) {
			System.out.print(c);
			System.out.print(",  ");
		}
	}
	
	public void displayHangman() {
		switch (this.availableTry) {
		case 6:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 5:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 4:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=       |");
			System.out.println("=       |");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 3:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=      /|");
			System.out.println("=       |");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 2:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=      /|\\");
			System.out.println("=       |");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 1:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=      /|\\");
			System.out.println("=       |");
			System.out.println("=      /");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
		case 0:
			System.out.println("=========");
			System.out.println("=       |");
			System.out.println("=       O");
			System.out.println("=      /|\\");
			System.out.println("=       |");
			System.out.println("=      / \\");
			System.out.println("=");
			System.out.println("=");
			System.out.println("=");
			break;
			
		}
	}
}






















