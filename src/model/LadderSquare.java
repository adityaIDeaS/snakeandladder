package model;

public class LadderSquare extends Square {

	private int increasePosition;

	public LadderSquare(int position, int increasePos, Game game) {
		super(position, game);
		increasePosition = increasePos;
	}

	public ISquare land() {
		return getGame().getSquare(getPosition() + increasePosition).land();
	}

	public int getIncreasePosition() {
		return increasePosition;
	}

	@Override
	public String toString() {
		return "LadderSquare [increasePosition=" + increasePosition
				+ ", toString()=" + super.toString() + "]";
	}
	
}
