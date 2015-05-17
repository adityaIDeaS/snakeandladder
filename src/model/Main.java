package model;

public class Main {

	public static void main(String[] args) {
		int[][] snakes = {{10,4},{15,9}};
		int[][] ladders = {{2,5},{6,9}};
		String[] name = {"player1","player2"};
		new Game(name, 16, snakes, ladders).play();
	}
}
