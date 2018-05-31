package yahtzeePackage;

public class StartSpel {

	
	
	static void starten() {
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
		System.out.println("Welkom bij Jahtzee!");
		System.out.println("Voer de naam van speler 1 in: ");
		speler1.naam = Yahtzee.invoeren();
		System.out.println("Voer de naam van speler 2 in: ");
		speler2.naam = Yahtzee.invoeren();
		System.out.println("Naam speler 1: " + speler1.naam + " en naam speler 2: "+ speler2.naam);
		System.out.println("Test");
	}
};
