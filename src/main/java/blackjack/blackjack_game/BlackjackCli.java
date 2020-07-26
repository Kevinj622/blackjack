package blackjack.blackjack_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.menu.Menu;

public class BlackjackCli {
	
	private static Menu menu;
	private static Card card;
	private static Deck deck;
	private static Hand userHand;
	private static Hand dealerHand;
	private static int nextCard = 0;
	private static int userScore = 0;
	private static int dealerScore = 0;
	private static final String GREETING = "Welcome to Blackjack!";
	private static final String MAIN_MENU_OPTION_PLAY_GAME = "Deal";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String HIT = "Hit";
	private static final String STAND = "Stand";
	private static final String QUIT = "Quit";
	
	private static final String [] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_PLAY_GAME, MAIN_MENU_OPTION_EXIT};
	private static final String [] GAME_OPTIONS = {HIT, STAND, QUIT};
	
	

	public static void main(String[] args) {
		
		System.out.println(GREETING);
		Menu menu = new Menu(System.in, System.out);
		BlackjackCli blackjackCli = new BlackjackCli(menu);
		blackjackCli.run();
		
		deck = new Deck();
		
		deck.shuffle();
	
	}
	

	
	public BlackjackCli(Menu menu) {
		this.menu = menu;
		
	}
	
	public void run() {
		while(true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_PLAY_GAME)) {
				Menu gameMenu = new Menu(System.in, System.out);
				BlackjackCli cli2 = new BlackjackCli(gameMenu);
				cli2.runGame();
		} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
			System.out.println("Thanks for playing!");
			break;
		}
	}
	
	}
	
	public void runGame() {
		deck = new Deck();
		Card[] shuffled = deck.shuffle();
		deal(shuffled);
		while(true) {
			String choice = (String) menu.getChoiceFromOptions(GAME_OPTIONS);
			if (choice.equals(HIT)) {
				nextCard++;
				userHand.addCard(shuffled[nextCard]);
				System.out.println("Your hand: " + userHand.toString());
				System.out.println("Dealer's hand: " + dealerHand.toString());
		} else if (choice.equals(QUIT)) {
			System.out.println("Quit and return to main menu");
			break;
		}
		} 
	}
	
	public void deal(Card [] array) {
		
		
		userHand = new Hand();
		dealerHand = new Hand();
		
		for (int i = 0; i < 2; i++) {
			
			userHand.addCard(array[nextCard]);
			userScore += userHand.score(array[nextCard]);
			nextCard++;
			dealerHand.addCard(array[nextCard]);
			dealerScore += userHand.score(array[nextCard]);
			nextCard++;
		}
		System.out.println("Your hand: " + userHand.toString() + " " + userScore);
		System.out.println("Dealer's hand: " + dealerHand.toString() + " " + dealerScore);
	}
	

}
