package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {
	
	
	/* LAB 2 - CISC181 - FALL2017 - LAB SECTION 30 - LECTURE SECTION 11 - GROUP 4
	 * Group Members:
	 * Joseph Stramandinoli
	 * Victoria DeSpirito
	 * Thomas Carey
     * Xin Xin
	 */
	
	
	
	
	//	COMPLETE: Card has two attributes, eRank and eSuit, add these attributes
	private eRank eRank;
	private eSuit eSuit;
	
	//	COMPLETE: Build a constructor for Card passing in eRank and eSuit
	public Card(eSuit suit, eRank rank) {
		seteSuit(suit);
		seteRank(rank);
	}
	
	//	COMPLETE: Add a public 'getter' method for eRank and eSuit.  
	//			Add a private 'setter' method for eRank and eSuit
	
	public eSuit geteSuit() {
		return eSuit;
	}

	public void seteSuit(eSuit eSuit) {
		this.eSuit = eSuit;
	}

	public eRank geteRank() {
		return eRank;
	}

	private void seteRank(eRank eRank) {
		this.eRank = eRank;
	}

	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().compareTo(this.geteRank());

}
	
}
