package yahtzeePackage;

public class StartSpel {
	
	
	
	static void starten() {
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
		System.out.println("Welkom bij Jahtzee!");
		System.out.println("Voer de naam van speler 1 in: ");
		speler1.naam = Yahtzee.invoeren();
		speler1.scorekaart = new Scorekaart();
		System.out.println("Voer de naam van speler 2 in: ");
		speler2.naam = Yahtzee.invoeren();
		speler2.scorekaart = new Scorekaart();
		// System.out.println("Naam speler 1: " + speler1.naam + " en naam speler 2: "+ speler2.naam);
		System.out.println("Bedankt voor het invoeren. Het spel gaat beginnen!");
		Speler spelerAanZet = speler1;
		// System.out.println("speler aan zet:  " + spelerAanZet.naam );
		Beker beker = new Beker();
		beker.setSpelers(speler1, speler2, spelerAanZet);
		beker.beurt();
	}
}
