package blackjack.blackjack_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

	private Card[] cards;
	private Card[] shuffled;
	private Hand userHand;
	private Hand dealerHand;
	private int nextCard = 0;
	private int score = 0;


	public int getNextCard() {
		return nextCard;
	}
	
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
	
	public void deal(Card [] array) {
		
		userHand = new Hand();
		dealerHand = new Hand();
		
		for (int i = 0; i < 2; i++) {
			userHand.addCard(array[nextCard]);
			nextCard++;
			dealerHand.addCard(array[nextCard]);
			nextCard++;
	
		}
		
		System.out.println("Your hand: " + userHand.toString());
		System.out.println("Dealer's hand: " + dealerHand.toString());
	
	}
	
	

	
}
	




