package com;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println();
				System.out.println("=================================");
				System.out.println("============ Hangman ============");
				System.out.println("=================================");
				System.out.print("Start Game: (y/n): ");
				String choice = scan.next();
				choice.toLowerCase();

				switch (choice) {
					case "y":
						game.startGame();
						break;
						
					case "n":
						System.exit(0);
						
					default:
						defaultMsg();
						break;
				}
			} catch (InputMismatchException e) {
				defaultMsg();
			}
		}
		
	}
	
	static void defaultMsg() {
		System.out.println("Wrong choice !!!  'y' or 'n'");
		System.out.println("-------------------------------------------------");
	}
}
