package snakeandladder;

import snakeandladder.exception.InvalidInputException;

public class Main {
	
	public static void main(String[] args) {
		int[][] snakes = { { 10, 4 }, { 15, 9 } };
		int[][] ladders = { { 2, 5 }, { 6, 9 } };
		String[] name = { "player1", "player2" };
		try {
			new Game(name, 16, snakes, ladders).play();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
}
