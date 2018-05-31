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
	
}
