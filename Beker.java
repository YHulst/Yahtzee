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
			}
	
		
	void beurt() {
		System.out.println(" ");
		System.out.println(spelerAanZet.naam + " is aan de beurt.");
		ArrayList<Dobbelsteen> dobstenen = new ArrayList();
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		dobstenen.add(new Dobbelsteen());
		gooien(dobstenen);
		
		beurtWisseling();
		System.out.println("Nu is " + spelerAanZet.naam);			
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
			// hier moet nog iets
			System.out.println("Je hebt 'ja' geantwoord");
			return worp;
		} else if (antwoord.equals("nee")) {
			System.out.println("Je hebt 'nee' geantwoord");
			return worp;
		} 
		
		return worp;
	}

}
