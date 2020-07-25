package blackjack.blackjack_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
	
	
	private int rank;
	private int suit;
	private int value;


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
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String[] getSuits() {
		return suits;
	}
	
	public void setSuits(String[] suits) {
		this.suits = suits;
	}
	
	public String[] getRanks() {
		return ranks;
	}
	
	public void setRanks(String[] ranks) {
		this.ranks = ranks;
	}
	


	
}
