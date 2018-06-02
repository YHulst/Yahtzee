package yahtzeePackage;

import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
			StartSpel.starten(); 

	}

	static String invoeren() {
		//System.out.println("Voer een woord in: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
	
	static char charInvoeren() {	
		// Scanner charScanner = new Scanner(System.in);
		Scanner reader = new Scanner(System.in);
		char c = reader.next().charAt(0);
		return c;
		// return charScanner.next().charAt(0);
	}
	
	
	
		
}
