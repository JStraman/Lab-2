package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private int iScore; // what is the point of this int variable?
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand()
	{
		ArrayList<Card> hand1 = new ArrayList<Card>();
		cards = hand1;
		
	}
	
	public int[] ScoreHand()
	{

		int [] iScore = new int[2];
		
		iScore[0] = 5;
		iScore[1] = 10;
		
		
		Collections.sort(cards);
		
		// I made a for loop to keep track of the minimum score and the number of aces.
		// I also declared an ArrayList<Integer> scores to store all of the possibles scores for after the loop is done.
		int currentScore = 0;
		int aces = 0;
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		
		//		COMPLETE: Determine the score.  
				//			Cards:
				//			2-3-4 - score = 11
				//			5-J-Q - score = 25
				//			5-6-7-2 - score = 20
				//			J-Q	- score = 20
				//			8-A = score = 9 or 19
				//			4-A = score = 5 or 15	
		for (Card c : cards)
		{
			if (c.geteRank().getiRankNbr() <= 10)
				currentScore += c.geteRank().getiRankNbr();
			else if(c.geteRank().getiRankNbr() < 14)
				currentScore += 10;
			else
			{
				currentScore += 1;
				aces++;
			}
		}
		
		// Here, I used a do-while loop to add all of the possible scores to the ArrayList scores.
		// This is also the point where the int aces comes into play.
		// For every ace I added a new score to the ArrayList equal to ten greater than the last,
		//    to emulate the choice of considering the Ace to be worth 1 or 11.
		do {
			scores.add(currentScore);
			currentScore += 10;
			aces--;
		} while (aces >= 0);

		// At this point I transfer the contents of the ArrayList<Card> scores to the int[] iScore
		// I check to make sure that scores has a second element before transferring that over to iScore
	    iScore[0] = scores.get(0);
	    if (scores.size() > 1) {
	    	iScore[1] = scores.get(1);
	    	if (iScore[1] == 21) {      // In response to Test 4, I added an if statement to swap iScore[1] and [0] if [1] is 21.
	    		int temp = iScore[1];
	    		iScore[1] = iScore[0];
	    		iScore[0] = temp;
	    	}
	    		
	    }
	    
	    // Finally, we return the final array int[] iScore, containing all of the possible scores as requested.
	      
	    
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		// We WOULD do the following if we didn't care about Encapsulation. But we do. Finish AddCard first. 
		//cards.add(d.draw());
		
		//	COMPLETE: add a card to 'cards' from a card drawn from Deck d
		this.AddCard(d.draw());
	}
	
	private void AddCard(Card c)
	{
		// Catch 22: find a way to call this method for testing purposes without changing the access modifier
		// The solution: Java Reflections
		cards.add(c);
	}
	
}
