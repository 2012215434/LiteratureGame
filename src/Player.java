import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private int playerNumber;
	private String team;
	public ArrayList<Card> hands = new ArrayList<Card>();
	private int score = 0;

	public Player(int playerNumber, String team) {
		this.playerNumber = playerNumber;
		this.setTeam(team);
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean askForACard(Player p, Card c) {
		ArrayList<Card> pHands = p.hands;
		for (Card c1 : pHands) {
			if (c1.equals(c)) {
				p.hands.remove(c1);
				this.hands.add(c);
				return true;
			}
		}
		return false;
	}

	/**
	 * public void checkForSuit(){ for(Suit suit:Suit.values()){ boolean isLow =
	 * checkForLowRank(suit); boolean isHigh =checkForHighRank(suit);
	 * if(isLow||isHigh){
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * private boolean checkForLowRank(Suit suit){ boolean[] f = new boolean[6];
	 * for(Card c: hands){ if(c.getSuit()==suit){ switch(c.getRank()){ case
	 * THREE: f[0]=true; break; case FOUR: f[1]=true; break; case FIVE:
	 * f[2]=true; break; case SIX: f[3] = true; break; case SEVEN: f[4] = true;
	 * break; case EIGHT: f[5]=true; break; default: break; } } } for(int i=0;
	 * i<f.length; i++){ if(!f[i]){ return false; } } return true; }
	 * 
	 * private boolean checkForHighRank(Suit suit){ boolean[] f = new
	 * boolean[6]; for(Card c: hands){ if(c.getSuit()==suit){
	 * switch(c.getRank()){ case NINE: f[0]=true; break; case TEN: f[1]=true;
	 * break; case JACK: f[2]=true; break; case QUEEN: f[3] = true; break; case
	 * KING: f[4] = true; break; case ACE: f[5]=true; break; default: break; } }
	 * } for(int i=0; i<f.length; i++){ if(!f[i]){ return false; } } return
	 * true; }
	 */

	public boolean declareCompletionOfASuit(boolean isLow, int suit) {
		boolean ret = check(isLow,suit);
		if(!ret){
			return false;
		}
		if (isLow) {
			hands.remove(new Card(3, suit));
			hands.remove(new Card(4, suit));
			hands.remove(new Card(5, suit));
			hands.remove(new Card(6, suit));
			hands.remove(new Card(7, suit));
			hands.remove(new Card(8, suit));
			this.score = this.score + 1;
			System.out.println("this palyer score: "+score);
		} else {

			hands.remove(new Card(9, suit));
			hands.remove(new Card(10, suit));
			hands.remove(new Card(11, suit));
			hands.remove(new Card(12, suit));
			hands.remove(new Card(13, suit));
			hands.remove(new Card(1, suit));
			this.score = this.score + 2;
		}
		this.sortCards();
		return true;
	}

	private boolean check(boolean isLow, int suit) {
		if (isLow) {
			boolean f = true;
			for (int i = 3; i <= 8; i++) {
				if (!hands.contains(new Card(i, suit))) {
					f = false;
				}
			}
			return f;
		} else {
			boolean f = true;
			for (int i = 9; i <= 13; i++) {
				if (!hands.contains(new Card(i, suit))) {
					f = false;
				}
			}
			if (!hands.contains(new Card(1, suit))) {
				f = false;
			}
			return f;
		}
	}

	@SuppressWarnings("unchecked")
	public void sortCards() {
		Collections.sort(hands);
	}
}
