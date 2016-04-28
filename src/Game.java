
public class Game {
	private int numberOfPlayersInEachTeam = 3;

	public Player[] teamA = new Player[numberOfPlayersInEachTeam];
	public Player[] teamB = new Player[numberOfPlayersInEachTeam];

	public Player turn;

	public Game() {
		for (int i = 0; i < teamA.length; i++) {
			teamA[i] = new Player(i+1, "teamA");
		}
		for (int i = 0; i < teamB.length; i++) {
			teamB[i] = new Player(i+1, "teamB");
		}
		turn = teamA[0];
	}

	public void dealCard() {
		Deck deck = new Deck();
		deck.shuffle();
		while (deck.cardsLeft() > 0) {
			for (int i = 0; i < teamA.length; i++) {
				if (deck.cardsLeft() >= 2) {
					teamA[i].hands.add(deck.dealCard());
					teamB[i].hands.add(deck.dealCard());
				}
			}
		}
		for (int i = 0; i < teamA.length; i++) {
			teamA[i].sortCards();
			teamB[i].sortCards();
		}

	}

	public int getScore(boolean isTeamA) {
		int score = 0;
		if (isTeamA) {
			for (int i = 0; i < teamA.length; i++) {
				System.out.println("palyer"+i+teamA[i].getScore());
				score = score + teamA[i].getScore();
			}
		} else {
			for (int i = 0; i < teamB.length; i++) {
				score = score + teamB[i].getScore();
			}
		}
		System.out.println("score:"+score);
		return score;
	}
}
