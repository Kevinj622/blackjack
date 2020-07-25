package blackjack.blackjack_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
	
	
	private int rank;
	private int suit;

	private String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	private String [] ranks = {null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString() {
		
		String s = ranks[this.rank] + " of " + suits[this.suit];
		return s;
		
	}
	


	
}
