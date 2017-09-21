package pkgCore;
import java.util.ArrayList;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	//	COMPLETE: Add 'cards' attribute that is an ArrayList of Card
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	//	COMPLETE: Add a constructor that passes in the number of decks, and then populates
	//			ArrayList<Card> with cards (depending on number of decks).

	//			Example: Deck(1) will build one 52-card deck.  There are 52 different cards
	//			2 clubs, 3 clubs... Ace clubs, 2 hearts, 3 hearts... Ace hearts, etc
	
	//			Deck(2) will create an array of 104 cards.
	
	public Deck(int numberOfDecks) {
		for (int i = 0; i < numberOfDecks; i++) {
			for (eSuit eSuit : eSuit.values()) {
				for (eRank eRank : eRank.values()) {
					cards.add(new Card(eSuit, eRank));
				}
			}
		}
	}

	
	
	//	COMPLETE: Add a draw() method that will take a card from the deck and
	//			return it to the caller
	
	public Card draw() {
		Card c = cards.get(cards.size());
		cards.remove(cards.size());
		return c;
	}
	
	public int getDeckSize() {
		//System.out.println(cards.size());
		return cards.size();
	}
	
}
