package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		//	COMPLET: Build a deck(1), make sure there are 52 cards in the deck
		//	COMPLETE: Build a deck(6), make sure there are 312 cards in the deck 
		
		Deck d1 = new Deck(1);
		Deck d2 = new Deck(6);
		
		assertEquals(d1.getDeckSize(),52);
		assertEquals(d2.getDeckSize(),312);
	}

}
