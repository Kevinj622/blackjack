package blackjack.blackjack_game;

import java.util.Arrays;
import java.util.Random;

public class Deck {

	private Card[] cards;
	
	public Deck(Card[] cards) {
		this.cards = cards;
	}
	
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}
	
	
	int getNextCard() {
		boolean init[] = new boolean[52];
		Random r = new Random();
		int i = r.nextInt(52);
		while(init[i]) 
			i = r.nextInt(52);
		init[i] = true;
		return i;
	}
	
	public void shuffle() {
			
		Card [] shuffled = new Card[52];
		
		for (int i = 0; i < shuffled.length; i++) {
			shuffled[i] = this.cards[getNextCard()];
		}
		
		 System.out.println(Arrays.toString(shuffled));
	}
	

	
}
	




