package blackjack.menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
	
	
	private Scanner in;
	private PrintWriter out;
	DecimalFormat dollars = new DecimalFormat("#0.00");
	
	public Menu(InputStream input, OutputStream output) {
		this.in = new Scanner(input);
		this.out = new PrintWriter(output);
	}
	
	public Object getChoiceFromOptions(Object[] options, BigDecimal currentMoney, BigDecimal wager) {
		Object choice = null;
		
		while(choice == null) {
			displayMenuOptions(options, currentMoney, wager);
			choice = getChoiceFromUserInput(options);
		}
		
		return choice;
	}
	
	private Object getChoiceFromUserInput(Object[] options) {
		
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1]; 
			}
		    } catch (NumberFormatException nfe) {
		        System.out.println("You must enter a number");
		    } catch (NoSuchElementException nse) {
		        System.out.println("That number doesn't exist");
		    }
		    return choice;
	}

	
	private void displayMenuOptions(Object[] options, BigDecimal currentMoney, BigDecimal wager) {
	    out.println();
	    for (int i = 0; i < options.length; i++) {
	        int optionNumber = i + 1;
	        out.println(optionNumber + ") " + options[i]);
	    }
	    System.out.println();
	    out.println("Please choose an option >>> ");
	    out.println("Current balance:  " + dollars.format(currentMoney));
	    out.println("Current bet: " + dollars.format(wager));
	 
	    out.flush();
	}
	

}
