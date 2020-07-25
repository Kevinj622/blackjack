package blackjack.blackjack_game;

import java.util.List;

import blackjack.menu.Menu;

public class BlackjackCli {
	
	private static Menu menu;
	private static Card card;
	private static Deck deck;
	private static final String GREETING = "Welcome to Blackjack!";
	private static final String MAIN_MENU_OPTION_PLAY_GAME = "Play game";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	
	private static final String [] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_PLAY_GAME,
															MAIN_MENU_OPTION_EXIT
														};
	private static final String GAME_OPTIONS_STAY = "Stay";
	

	public static void main(String[] args) {
		
//		System.out.println(GREETING);
//		Menu menu = new Menu(System.in, System.out);
//		BlackjackCli blackjackCli = new BlackjackCli(menu);
//		blackjackCli.run();
//		
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
			
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}
	
	
	
	
	

}
