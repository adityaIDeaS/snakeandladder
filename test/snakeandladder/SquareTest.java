package snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import snakeladder.Game;
import snakeladder.ISquare;
import snakeladder.Player;
import snakeladder.Square;

public class SquareTest {

	public static final int[] LADDER = { 1, 4 };
	
	public static final int[] SNAKE = { 9, 3 };
	
	private Game game;

	@Before
	public void setUp() throws Exception {
		game = TestUtils.setUpGame();
	}

	@Test
	public void testMove(){
		ISquare s = game.getFirstSquare();
		ISquare newSquare = s.move(3);
		Assert.assertEquals(3,newSquare.getPosition());
	}

	@Test
	public void testMoveOnSnakeSquare(){
		ISquare s = game.getSquare(8);
		ISquare newSquare = s.move(1);
		Assert.assertEquals(SNAKE[1],newSquare.getPosition());
	}

	@Test
	public void testMoveOnLadderSquare(){
		ISquare s = game.getFirstSquare();
		ISquare newSquare = s.move(1);
		Assert.assertEquals(LADDER[1],newSquare.getPosition());
	}
	
	@Test
	public void testAddAndRemovePlayer(){
		Square s = (Square) game.getFirstSquare();
		Player player = new Player("Player1");
		s.addPlayer(player);
		s.remove(player);
		Assert.assertEquals(0,s.getPlayers().size());
	}
}
