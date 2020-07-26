package blackjack.blackjack_game;

import java.util.Vector;

public class Hand {
	
	
	private Vector hand;
	
	public Hand() {
		hand = new Vector();
	}
	
	public void clear() {
		hand.removeAllElements();
	}
	
	public void addCard(Card c) {
		if (c != null) {
			hand.addElement(c);
		}
		
	}
	
	public void removeCard(Card c) {
		hand.removeElement(c);
	}
	
	public void removeCard(int position) {
		if (position > 0 && position <= hand.size()) {
			hand.removeElementAt(position);
			
		}
	}
	
	public String toString() {
		String s = hand.toString();
		return s;
	}
	
	public int score(Card c) {
		int score = 0;
		
		
		for (int i = 1; i < c.getRanks().length - 6; i++) {
			if (c.getRanks()[i].equals("King") || (c.getRanks()[i].equals("Queen") 
					|| (c.getRanks()[i].equals("Jack")))) {
						
				score = 10;
					}
			else {
				score = Integer.valueOf(c.getRanks()[i]);
			}
		}
		return score;
		
	}
	
	

}
