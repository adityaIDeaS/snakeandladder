package model;

public class SnakeSquare extends Square {
	private int decreasePosition;

	public SnakeSquare(int position, int decreasePosition, Game game) {
		super(position, game);
		this.decreasePosition = decreasePosition;
	}

	public ISquare land() {		
		return getGame().getSquare(getPosition()-decreasePosition).land();
	}

	public int getDecreasePosition() {
		return decreasePosition;
	}

	@Override
	public String toString() {
		return super.toString() + " SnakeSquare [decreasePosition=" + decreasePosition + "]";
	}

}
