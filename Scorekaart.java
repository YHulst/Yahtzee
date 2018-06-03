package yahtzeePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scorekaart {
/*	int enen;
	int tweeen;
	int drieen;
	int vieren;
	int vijfen;
	int zessen;
	int drieDezelfde;
	int vierDezelfde;
	int fullHouse;
	int kleineStraat;
	int groteStraat;
	int yahtzee;
	int vrijeKeus;	*/
	Speler spelerAanZet;
	HashMap<String, Integer> totaalScore;
	
	
	Scorekaart(){
		// ArrayList<Integer> totaalScore = new ArrayList<>();
		// int x = 5;
		// totaalScore.add(x);
		totaalScore = new HashMap<String, Integer>();
		totaalScore.put("enen", 0);
		totaalScore.put("tweeen", 0);
		totaalScore.put("drieen", 0);
		totaalScore.put("vieren", 0);
		totaalScore.put("vijfen", 0);
		totaalScore.put("zessen", 0);
		totaalScore.put("drieDezelfde", 0);
		totaalScore.put("vierDezelfde", 0);
		totaalScore.put("fullHouse", 0);
		totaalScore.put("kleineStraat", 0);
		totaalScore.put("groteStraat", 0);
		totaalScore.put("yahtzee", 0);
		totaalScore.put("vrijeKeus", 0);		
	}
	
	void setSpelerAanZet(Speler speler) {
		this.spelerAanZet = speler;
	}
	
	void toonMenu() {
		System.out.println("\n" + "Laten we je scorekaart erbij pakken! De volgende vakjes zijn nog open:");
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		int teller = 0;
		for (Map.Entry vakje : totScore.entrySet()) {
			Integer waarde = (int) vakje.getValue();
			if (waarde == 0) {
				System.out.print(vakje.getKey() + "    ");
				teller++;
				if (teller == 6) { 	System.out.println(" "); 	}
			}			
			}
		System.out.println("\n" + "Welk vakje wil je gebruiken? Type de naam van het vakje: ");	
		String antwoord = Yahtzee.invoeren();
		boolean beschikbaar = false;
		while (beschikbaar == false) {
			for (Map.Entry vakje : totScore.entrySet()) {
				String key = (String) vakje.getKey();
				if (key.equals(antwoord)){ 	beschikbaar = true;	}
			} 
			if (beschikbaar == false) {
				System.out.println("Type de naam van 1 van bovenstaande vakjes.");
				antwoord = Yahtzee.invoeren();
			}
		}
		switch (antwoord) {
			case "enen":
				// schrijf iets
				break;
			case "tweeen": 
				// schrijf iets
				break;
			case "drieen":
				// schrijf iets
				break;
			case "vieren":
				// schrijf iets
				break;
			case "vijfen":
				// schrijf iets
				break;
			case "zessen":
				// schrijf iets
				break;
			case "drieDezelfde":
				// schrijf iets
				break;
			case "vierDezelfde":
				// schrijf iets
				break;
			case "fullHouse":
				// schrijf iets
				break;
			case "kleineStraat":
				// schrijf iets
				break;
			case "groteStraat":
				// schrijf iets
				break;
			case "yahtzee":
				// schrijf iets
				break;
			case "vrijeKeus":
				// schrijf iets
				break;
		}
	}
	
	
	
	
}
