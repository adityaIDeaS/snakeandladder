package snakeladder;

public interface ISquare {

	void remove(Player player);

	void enter(Player player);

	ISquare move(int position);
	
	ISquare land();

	Game getGame();

	int getPosition();
}
