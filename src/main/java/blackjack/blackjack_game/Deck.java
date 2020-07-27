package blackjack.blackjack_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

	private Card[] cards;
	private Card[] shuffled;
	private int nextCard = 0;



	public int getNextCard() {
		return nextCard;
	}
	
	public Deck(Card[] cards) {
		this.cards = cards;
	}
	
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		int value = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				if (rank >= 10) {
					value = 10;
				} else {
					value = rank + 1;
				}
				this.cards[index] = new Card(rank, suit, value);
				index++;
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}
	
	
	int shuffleHelper() {
		boolean init[] = new boolean[52];
		Random r = new Random();
		int i = r.nextInt(52);
		while(init[i]) 
			i = r.nextInt(52);
		init[i] = true;
		return i;
	}
	
	public Card [] shuffle() {
			
		this.shuffled= new Card[52];
		
		for (int i = 0; i < shuffled.length; i++) {
			shuffled[i] = this.cards[shuffleHelper()];
		}
	
		return shuffled;
	}
	

	
	

	
}
	




