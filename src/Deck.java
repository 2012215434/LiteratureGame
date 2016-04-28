
public class Deck {

	private static Card[] cards = new Card[48];

	private static int cardsUsed;

	public Deck() {
		int i = 0;
		for (int rank = 1;rank<14;rank++) {
			for (int suit=1;suit<5;suit++ ) {
				if (rank != 2) {
					cards[i++] = new Card(rank, suit);
				}
			}
		}
	}

	public void shuffle() {
		for (int i = cards.length - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Card temp = cards[i];
			cards[i] = cards[rand];
			cards[rand] = temp;
		}
		cardsUsed = 0;
	}

	public int cardsLeft() {
		return cards.length - cardsUsed;
	}

	public Card dealCard() {
		if (cardsUsed == cards.length)
			throw new IllegalStateException("No cards are left in the deck.");
		cardsUsed++;
		return cards[cardsUsed - 1];
	}

}
