
@SuppressWarnings("rawtypes")
public class Card implements Comparable{
	private final int rank;
	private final int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		if (rank != other.rank) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Object o) {
		if(this.rank==((Card)o).rank){
			return this.suit-((Card)o).suit;
		}else{
			return  this.rank-((Card)o).rank;
		}
	}
	
	public int getIconIndex(){
		if(this.rank==1){
			return suit;
		}else{
			return (14-rank)*4+suit;
		}
	}
	
	public static int getRankFromString(String s){
		switch(s){
		case "A" :
			return 1;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			return Integer.valueOf(s);
					
		}
	}
	
	public static int getSuitFromString(String s){
		switch(s){
		case "Clubs":
			return 1;
		case "Spades":
			return 2;
		case "Hearts":
			return 3;
		case "Diamonds":
			return 4;
		default:
			return 1;
		}
	}
}
