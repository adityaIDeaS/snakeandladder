package model;

public class Player {

	private String name;
	private ISquare square;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ISquare getSquare() {
		return square;
	}

	public void setSquare(ISquare square) {
		this.square = square;
	}

	public void moveForward(int position) {
		square.remove(this);
		ISquare newSquare = square.move(position);
		newSquare.enter(this);
		setSquare(newSquare);
	}

	public boolean isWinner() {
		return (square.getGame().getLastSquare().getPosition() == square
				.getPosition());
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", square=" + square + "]";
	}
	
}
