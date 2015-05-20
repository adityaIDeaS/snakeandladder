package snakeandladder;

import snakeladder.exception.InvalidInputException;

public class TestUtils {

	public static final int[][] SNAKES = { { 10, 4 }, { 15, 9 } };

	public static final int[][] LADDERS = { { 2, 5 }, { 6, 9 } };

	public static final String[] PLAYERS = { "player1", "player2" };

	public static final int BOARD_SIZE = 16;

	public static Game setUpGame() throws InvalidInputException {

		return new Game(PLAYERS, BOARD_SIZE, SNAKES, LADDERS);
	}

}
