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
	private static final String YES = "Yes";
	private static final String NO = "No";
	
	private static final String [] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_PLAY_GAME, MAIN_MENU_OPTION_EXIT};
	private static final String [] GAME_OPTIONS = {HIT, STAND, QUIT};
	private static final String [] POST_GAME_OPTIONS = {YES, NO};
	
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
		showHands();
		while(true) {
			String choice = (String) menu.getChoiceFromOptions(GAME_OPTIONS);
			if (choice.equals(HIT)) {
				nextCard++;
				userHand.addCard(shuffled[nextCard]);
				userScore += shuffled[nextCard].getValue(shuffled[nextCard]);
				showHands();
				gameLogic();
		} else if (choice.equals(QUIT)) {
			
			break;
		}
		} 
	}
	
	public void deal(Card [] array) {
		
		
		userHand = new Hand();
		dealerHand = new Hand();
		
		for (int i = 0; i < 2; i++) {
			
			userHand.addCard(array[nextCard]);
			userScore += array[nextCard].getValue(array[nextCard]);
			nextCard++;
			dealerHand.addCard(array[nextCard]);
			dealerScore += array[nextCard].getValue(array[nextCard]);
			nextCard++;
		}
	}
	
	public void showHands() {
		System.out.println("Your hand: " + userHand.toString() + " " + userScore);
		System.out.println("Dealer's hand: " + dealerHand.toString() + " " + dealerScore);
		
	}
	
	public void gameLogic() {
		if (userScore > 21) {
			System.out.println("Bust!");
		} else if (dealerScore > userScore) {
			System.out.println("Dealer wins!");
		} else if (userScore > dealerScore) {
			System.out.println("You win! Yay!");
		}
		
		while (true) {
			System.out.println("Play Again?");
			String choice = (String) menu.getChoiceFromOptions(POST_GAME_OPTIONS);
			if (choice.equals(YES)) {
				userScore = 0;
				dealerScore = 0;
				runGame();
			} else {
				break;
			}
		}
	}

}
