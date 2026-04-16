package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	Game game;
	
	@BeforeEach
	void init() {
		game = new Game();
	}

	@Test
	void testAucuneQuille() {
		for (int i = 0; i < 20; i++) 
			game.roll(0);
		assertEquals(0, game.score());
	}
	
	@Test
	void testUneQuille() {
		game.roll(1);
		for (int i = 0; i < 19; i++) 
			game.roll(0);
		assertEquals(1, game.score());
	}
	
	@Test
	void testPlusieursQuilles() {
		game.roll(6);
		for (int i = 0; i < 19; i++) 
			game.roll(0);
		assertEquals(6, game.score());
	}
	
	@Test
	void testPlusieursLancers() {
		game.roll(4);
		game.roll(0);
		game.roll(16);
		for (int i = 0; i < 17; i++) 
			game.roll(0);
		assertEquals(20, game.score());
	}
}
