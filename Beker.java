package yahtzeePackage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;



public class Beker {
	Speler speler1;
	Speler speler2;
	Speler spelerAanZet;
	Dobbelsteen dobstenen;

	void setSpelers(Speler speler1, Speler speler2, Speler spelerAanZet){
		this.speler1 = speler1;
		this.speler2 = speler2;
		this.spelerAanZet = spelerAanZet;		
	}
	
	void beurtWisseling() {
		if (spelerAanZet == speler1) {
			spelerAanZet = speler2;
		} else if (spelerAanZet == speler2) {
			spelerAanZet = speler1;
		}
		System.out.println(" ");
		System.out.println("Nu is " + spelerAanZet.naam + ".");
		beurt();
			}
	
		
	void beurt() {	
		spelerAanZet.aantalBeurten += 1;
		ArrayList<Dobbelsteen> dobstenen = new ArrayList();
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		ArrayList<Dobbelsteen> worp = gooien(dobstenen);	
		spelerAanZet.scorekaart.setSpelerAanZet(spelerAanZet);
		spelerAanZet.scorekaart.toonMenu(worp);		
		if (speler2.aantalBeurten == 11) {
			spelStoppen();
		}
		beurtWisseling();					
	}
	
	void spelStoppen() {
		System.out.print("\n" + "Einde spel. ");
		if (speler1.totaleScore > speler2.totaleScore) {
			System.out.println(speler1.naam + " heeft gewonnen!");
		} else if (speler1.totaleScore < speler2.totaleScore) {
			System.out.println(speler2.naam + " heeft gewonnen!");
		} else if (speler1.totaleScore == speler2.totaleScore) {
			System.out.println("Het is gelijkspel!");
		}
		System.out.println("Eindscore " + speler1.naam + ": " + speler1.totaleScore + " punten.");
		System.out.println("Eindscore " + speler2.naam + ": " + speler2.totaleScore + " punten.");
	}
	
	
	
	
	ArrayList<Dobbelsteen> gooien(ArrayList<Dobbelsteen> worp){
		System.out.print("Dit is je eerste worp: ");				
		for (Dobbelsteen dobst : worp) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
			dobst.aantalOgen = randomNum;
			System.out.print(dobst.aantalOgen + "   ");			
		}		
		System.out.println(" ");
		System.out.println("Wil je opnieuw gooien (ja/nee)?");
		String antwoord = Yahtzee.invoeren();
		while (!(antwoord.equals("ja")) && !(antwoord.equals("nee"))) {
			System.out.println("Type ja of nee");
			antwoord = Yahtzee.invoeren();
		}
		if (antwoord.equals("ja")) {		
			worp = opnieuwGooien(worp);
			System.out.print("Je hebt voor de tweede keer gegooid! Uitkomst tweede worp: ");
			for (Dobbelsteen dobst : worp) {
				System.out.print(dobst.aantalOgen + "   ");	}
			System.out.println(" ");
			System.out.println("Wil je opnieuw gooien (ja/nee)?");
			antwoord = Yahtzee.invoeren();
			while (!(antwoord.equals("ja")) && !(antwoord.equals("nee"))) {
				System.out.println("Type ja of nee");
				antwoord = Yahtzee.invoeren();
			}
			if (antwoord.equals("ja")) {
				worp = opnieuwGooien(worp);
				System.out.print("Je hebt voor de derde keer gegooid! Uitkomst derde worp: ");
				for (Dobbelsteen dobst : worp) {
					System.out.print(dobst.aantalOgen + "   ");	}
				System.out.println("");
				return worp;
			} else if (antwoord.equals("nee")) {
				return worp;
			}
		} else if (antwoord.equals("nee")) {				
				return worp;
			}
		
				
		return worp;
	}
	
	
	
	ArrayList<Dobbelsteen> opnieuwGooien(ArrayList<Dobbelsteen> worp){
		System.out.println(" ");
		for (Dobbelsteen dobst : worp) {
			System.out.print("Wil je deze dobbelsteen opnieuw gooien? (ja/nee):  ");
			System.out.println(dobst.aantalOgen);
			String antwoord = Yahtzee.invoeren();
			while (!(antwoord.equals("ja")) && !(antwoord.equals("nee"))) {
				System.out.println("Type ja of nee");
				antwoord = Yahtzee.invoeren(); }
			if (antwoord.equals("ja")) {
					int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
					dobst.aantalOgen = randomNum;
					System.out.println("Je gooit deze dobbelsteen opnieuw.");
				}
			System.out.println(" ");
		}
		return worp;
		
	}

}
