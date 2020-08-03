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
	
	private static BigDecimal currentMoney;
	
	public Bet() {
	
	}
	
	public BigDecimal placeBet(BigDecimal currentTotal) {
		
		System.out.print("Select an amount: ");
		
		Scanner s = new Scanner(System.in);
		String value = s.nextLine();
		BigDecimal input = new BigDecimal(value);
		
		if (input.equals(ONE)) {
			currentTotal = currentTotal.add(ONE);
		} else if (input.equals(FIVE)) {
			currentTotal = currentTotal.add(FIVE);
		} else if (input.equals(TWENTY_FIVE)) {
			currentTotal = currentTotal.add(TWENTY_FIVE);
		} else if (input.equals(ONE_HUNDRED)) {
			currentTotal = currentTotal.add(ONE_HUNDRED);
		} else if (input.equals(FIVE_HUNDRED)) {
			currentTotal = currentTotal.add(FIVE_HUNDRED);
		} else if (input.equals(ONE_THOUSAND)) {
			currentTotal = currentTotal.add(ONE_THOUSAND);
		} else {
			System.out.println("Please enter a valid amount");
		}
		return currentTotal;
	}

}
