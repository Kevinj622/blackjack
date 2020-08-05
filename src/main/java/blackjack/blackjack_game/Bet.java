package blackjack.blackjack_game;

import java.math.BigDecimal;
import java.util.Scanner;

public class Bet {
	
	
	private static final BigDecimal ONE = BigDecimal.valueOf(1.00);
	private static final BigDecimal FIVE = BigDecimal.valueOf(5.00);
	private static final BigDecimal TWENTY_FIVE = BigDecimal.valueOf(25.00);
	private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100.00);
	private static final BigDecimal FIVE_HUNDRED = BigDecimal.valueOf(500.00);
	private static final BigDecimal ONE_THOUSAND = BigDecimal.valueOf(1000.00);
	
	private static final String choice1 = "$1.00";
	private static final String choice5 = "$5.00";
	private static final String choice25 = "$25.00";
	private static final String choice100 = "$100.00";
	private static final String choice500 = "$500.00";
	private static final String choice1000 = "$1,000.00";

	private static BigDecimal wager = BigDecimal.ZERO;
	
	public Bet() {

	}
	
	public BigDecimal placeBet(String input, BigDecimal startingTotal) {
		
		
		if (input.equals(choice1)) {
			startingTotal = startingTotal.subtract(ONE);
		} else if (input.equals(choice5)) {
			startingTotal = startingTotal.subtract(FIVE);
		} else if (input.equals(choice25)) {
			startingTotal = startingTotal.subtract(TWENTY_FIVE);
		} else if (input.equals(choice100)) {
			startingTotal = startingTotal.subtract(ONE_HUNDRED);
		} else if (input.equals(choice500)) {
			startingTotal = startingTotal.subtract(FIVE_HUNDRED);
		} else if (input.equals(choice1000)) {
			startingTotal = startingTotal.subtract(ONE_THOUSAND);
		} else {
			System.out.println("Please enter a valid amount");
		}
		
		
		
		return startingTotal;
	}
	
	public BigDecimal wager(String input, BigDecimal wager) {
		
		if (input.equals(choice1)) {
			wager = wager.add(ONE);
		} else if (input.equals(choice5)) {
			wager = wager.add(FIVE);
		} else if (input.equals(choice25)) {
			wager = wager.add(TWENTY_FIVE);
		} else if (input.equals(choice100)) {
			wager = wager.add(ONE_HUNDRED);
		} else if (input.equals(choice500)) {
			wager = wager.add(FIVE_HUNDRED);
		} else if (input.equals(choice1000)) {
			wager = wager.add(ONE_THOUSAND);
		} else {
			System.out.println("Please enter a valid amount");
		}
		return wager;
		
	}
	
	

}
