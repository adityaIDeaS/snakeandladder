package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Game {

	private List<ISquare> squares;
	private Queue<Player> players;
	private Player winner;

	public Game(String[] players, int squares, int[][] snakes, int[][] ladders) {
		createPlayers(players);
		createSquares(squares);
		addSnakes(snakes);
		addLadders(ladders);
	}

	public void play() {
		startGame();
		while (getWinner() == null) {
			int roll = roll();
			System.out.println("Roll: " + roll + " " + toString());
			movePlayer(roll);
		}
		System.out.println(toString());
	}

	private void movePlayer(int position) {
		Player player = players.remove();
		player.moveForward(position);
		players.add(player);
		if (isWinner(player)) {
			winner = player;
		}
	}

	private boolean isWinner(Player player) {
		return player.getSquare().getPosition() == getSquareSize() - 1;
	}

	private void startGame() {
		for (Player player : players) {
			getFirstSquare().enter(player);
			player.setSquare(getFirstSquare());
		}
		setWinner(null);
	}

	private int roll() {
		return new Random().nextInt(6) + 1;
	}

	private void addSnakes(int[][] snakes) {
		addSpecialSquare(snakes, true);
	}

	private void addLadders(int[][] ladders) {
		addSpecialSquare(ladders, false);
	}

	private void createPlayers(String[] names) {
		players = new LinkedList<Player>();
		for (String name : names) {
			players.add(new Player(name));
		}
	}

	private void createSquares(int size) {
		squares = new ArrayList<ISquare>();
		for (int i = 0; i < size; i++) {
			squares.add(new Square(i, this));
		}
	}

	private void addSpecialSquare(int[][] values, boolean isSnake) {
		for (int i = 0; i < values.length; i++) {
			int from = values[i][0] - 1;
			int to = values[i][1] - 1;
			squares.set(from, isSnake ? new SnakeSquare(from, from - to, this)
					: new LadderSquare(from, to - from, this));
		}
	}

	public ISquare getFirstSquare() {
		return squares.get(0);
	}

	public ISquare getLastSquare() {
		return squares.get(squares.size() - 1);
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public ISquare getSquare(int position) {
		return squares.get(position);
	}

	public int getSquareSize() {
		return squares.size();
	}

	@Override
	public String toString() {
		return "Game [ players=" + players
				+ ", winner=" + winner + "]";
	}
	
	
}
