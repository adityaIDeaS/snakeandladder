package snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class Square implements ISquare {

	private int position;
	private List<Player> players = new ArrayList<Player>();
	private Game game;
	private int shift = 0;

	public Square(int position, Game game) {
		this.position = position;
		this.game = game;
	}

	public Square(ISquare square, int shift) {
		this.position = square.getPosition();
		this.game = square.getGame();
		this.shift = shift;
	}

	@Override
	public ISquare move(int position) {
		int pos = getPosition() + position;
		if (pos < game.getSquareSize()) {
			return game.getSquare(pos).land();
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

	public ISquare land() {
		return getGame().getSquare(getPosition() + shift);
	}

	@Override
	public String toString() {
		return "Square [position=" + position + "]";
	}
}
