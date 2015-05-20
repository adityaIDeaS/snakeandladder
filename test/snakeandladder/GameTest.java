package snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import snakeladder.Game;

public class GameTest  {
	
	private Game game;

	@Before
	public void setUp() throws Exception {
		game = TestUtils.setUpGame();
	}

	@Test
	public void testGetFirstSquare(){
		Assert.assertEquals(0,game.getFirstSquare().getPosition());
	}
	
	@Test
	public void testGetLastSquare(){
		Assert.assertEquals(15,game.getLastSquare().getPosition());
	}
	
	@Test
	public void testGetSquareSize(){
		Assert.assertEquals(TestUtils.BOARD_SIZE,game.getSquareSize());
	}
	
	@Test
	public void testGetWinner(){
		game.play();
		Assert.assertNotEquals(null,game.getWinner());
	}
}
