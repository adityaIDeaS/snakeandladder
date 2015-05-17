package model;

public class Main {

	public static void main(String[] args) {
		int[][] snakes = {{11,5}};
		int[][] ladders = {{2,6},{7,9}};
		String[] name = {"player1","player2"};
		new Game(name, 12, snakes, ladders).play();
	}
}
