package blackjack.blackjack_game;

import java.math.BigDecimal;
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
	private static BigDecimal currentTotal = BigDecimal.valueOf(100.00);
	private static BigDecimal wager = BigDecimal.ZERO;
	private static Bet bet;
	private static int nextCard = 0;
	private static int userScore = 0;
	private static int dealerScore = 0;
	private static final String GREETING = "Welcome to Blackjack!";
	private static final String MAIN_MENU_OPTION_PLAY_GAME = "Deal";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String HIT = "Hit";
	private static final String STAY = "Stay";
	private static final String QUIT = "Quit";
	private static final String YES = "Yes";
	private static final String NO = "No";
	private static final String ONE = "$1.00";
	private static final String FIVE = "$5.00";
	private static final String TWENTY_FIVE = "$25.00";
	private static final String ONE_HUNDRED = "$100.00";
	private static final String FIVE_HUNDRED = "$500.00";
	private static final String ONE_THOUSAND = "$1,000.00";
	private static final String [] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_PLAY_GAME, MAIN_MENU_OPTION_EXIT};
	private static final String [] GAME_OPTIONS = {HIT, STAY, QUIT};
	private static final String [] POST_GAME_OPTIONS = {YES, NO};
	private static final String [] BET_OPTIONS = {ONE, FIVE, TWENTY_FIVE, ONE_HUNDRED, FIVE_HUNDRED, ONE_THOUSAND};
	
	public static void main(String[] args) {
		
		System.out.println(GREETING);
		Menu menu = new Menu(System.in, System.out);
		BlackjackCli blackjackCli = new BlackjackCli(menu, currentTotal, wager);
		blackjackCli.run();
	
	}
	
	public BlackjackCli(Menu menu, BigDecimal currentTotal, BigDecimal wager) {
		this.menu = menu;
		this.currentTotal = currentTotal;
		this.wager = wager;
	}
	
	public void run() {
		
		while(true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS, currentTotal, wager);
			if (choice.equals(MAIN_MENU_OPTION_PLAY_GAME)) {
				Menu gameMenu = new Menu(System.in, System.out);
				bet = new Bet();
				String selection = (String) menu.getChoiceFromOptions(BET_OPTIONS, currentTotal, wager);
				currentTotal = bet.placeBet(selection, currentTotal);
				wager = wager.add(bet.wager(selection, wager));
				BlackjackCli cli2 = new BlackjackCli(gameMenu, currentTotal, wager);
				cli2.runGame(currentTotal, wager);
		} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
			System.out.println("Thanks for playing!");
			break;
		}
	}
	}
	
	public void runGame(BigDecimal currentTotal, BigDecimal wager) {
		deck = new Deck();
		Card[] shuffled = deck.shuffle();
		deal(shuffled);
		while(true) {
			String choice = (String) menu.getChoiceFromOptions(GAME_OPTIONS, currentTotal, wager);
				if (choice.equals(HIT)) {
					nextCard++;
					userHand.addCard(shuffled[nextCard]);
					userScore += shuffled[nextCard].getValue(shuffled[nextCard]);
					nextCard++;
					if(dealerScore < 16) {
						dealerHand.addCard(shuffled[nextCard]);
						dealerScore += shuffled[nextCard].getValue(shuffled[nextCard]);
						nextCard++;
					} 
					showHands();
				} else if(choice.equals(STAY)) {
					nextCard++;
					if(dealerScore < 16) {
						dealerHand.addCard(shuffled[nextCard]);
						dealerScore += shuffled[nextCard].getValue(shuffled[nextCard]);
						nextCard++;
					} 
					showHands();
				} else if (choice.equals(QUIT)) {
					userScore = 0;
					dealerScore = 0;
					nextCard = 0;
					currentTotal = BigDecimal.valueOf(100.00);
					wager = BigDecimal.ZERO;
					break;
				}
				if((dealerScore <= 21 && dealerScore > userScore) || (userScore <= 21 && userScore > dealerScore)
						|| userScore >= 21 || dealerScore >= 21) {
					endGame();
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
		System.out.println("Your hand: " + userHand.toString() + " " + userScore);
		System.out.println("Dealer's hand: " + dealerHand.getCard(0) + ", hidden");
	}
	
	public void showHands() {
		System.out.println("Your hand: " + userHand.toString() + " " + userScore);
		System.out.println("Dealer's hand: " + dealerHand.toString() + " " + dealerScore);
	}
	
	public void gameLogic() {
		
			if (userScore > 21) {
				System.out.println("Bust!");
			} else if (dealerScore > 21) {
				System.out.println("Dealer Busted! You Win!");
				currentTotal = currentTotal.add(wager);
				currentTotal = currentTotal.add(wager);
			} else if (dealerScore > userScore && dealerScore <= 21) {
				System.out.println("Dealer Wins!");
			} else if (userScore > dealerScore && userScore <= 21) {
				System.out.println("You Win!");
				currentTotal = currentTotal.add(wager);
				currentTotal = currentTotal.add(wager);
			} else if (userScore == dealerScore && userScore < 21 && dealerScore < 21) {
				System.out.println("Push.");
				
			}
	}
	
	public void endGame() {
			gameLogic();
			while(true) {
				System.out.println("Play Again?");
				String choice1 = (String) menu.getChoiceFromOptions(POST_GAME_OPTIONS, currentTotal, wager);
				if (choice1.equals(YES)) {
					userScore = 0;
					dealerScore = 0;
					nextCard = 0;
					wager = BigDecimal.ZERO;
					runGame(currentTotal, wager);
				} else {
					userScore = 0;
					dealerScore = 0;
					nextCard = 0;
					break;
				}
			}
	}
}
