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
	public Card getCard(int i) {
		return (Card) hand.elementAt(i);
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
	
	
	

}
