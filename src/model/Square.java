package model;

import java.util.ArrayList;
import java.util.List;

public class Square implements ISquare {

	private int position;
	private List<Player> players = new ArrayList<Player>();
	private Game game;

	public Square(int position, Game game) {
		this.position = position;
		this.game = game;
	}

	@Override
	public ISquare move(int position) {
		int pos = getPosition() + position;
		if(pos < game.getSquareSize()) {
			return game.getSquare(pos).land() ;
		}
		return this;
	}

	public void remove(Player player) {
		players.remove(player);
	}

	public void enter(Player player) {
		players.add(player);
	}

	public int getPosition() {
		return position;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public Game getGame() {
		return game;
	}

	@Override
	public String toString() {
		return "Square [position=" + position + "]";
	}

	@Override
	public ISquare land() {
		return this;
	}

}
