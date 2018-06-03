package yahtzeePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scorekaart {
	Speler spelerAanZet;
	HashMap<String, Integer> totaalScore;
	
	
	Scorekaart(){
		totaalScore = new HashMap<String, Integer>();
		totaalScore.put("enen", 0);
		totaalScore.put("tweeen", 0);
		totaalScore.put("drieen", 0);
		totaalScore.put("vieren", 0);
		totaalScore.put("vijfen", 0);
		totaalScore.put("zessen", 0);
		totaalScore.put("drieDezelfde", 0);
		totaalScore.put("vierDezelfde", 0);
		totaalScore.put("kleineStraat", 0);
		totaalScore.put("groteStraat", 0);
		totaalScore.put("yahtzee", 0);				
	}
	
	void setSpelerAanZet(Speler speler) {
		this.spelerAanZet = speler;
	}
	
	void toonMenu(ArrayList<Dobbelsteen> worp) {
		System.out.println("\n" + "Laten we je scorekaart erbij pakken! De volgende vakjes zijn nog open:");
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		int teller = 0;
		for (Map.Entry vakje : totScore.entrySet()) {
			Integer waarde = (int) vakje.getValue();
			if (waarde == 0) {
				System.out.print(vakje.getKey() + "    ");
				teller++;
				if (teller == 5) { 	System.out.println(" "); 	}
			}			
			}
		System.out.println("\n" + "Welk vakje wil je gebruiken? Type de naam van het vakje: ");	
		String antwoord = Yahtzee.invoeren();
		boolean beschikbaar = false;
		while (beschikbaar == false) {
			for (Map.Entry vakje : totScore.entrySet()) {
				String key = (String) vakje.getKey();
				if (key.equals(antwoord) && (int) vakje.getValue() == 0){ 	beschikbaar = true;	}
			} 
			if (beschikbaar == false) {
				System.out.println("Type de naam van 1 van bovenstaande vakjes.");
				antwoord = Yahtzee.invoeren();
			}
		}
		switch (antwoord) {
			case "enen":
				checkLosseGetallen(1, worp, antwoord);
				break;
			case "tweeen": 
				checkLosseGetallen(2, worp, antwoord);
				break;
			case "drieen":
				checkLosseGetallen(3, worp, antwoord);
				break;
			case "vieren":
				checkLosseGetallen(4, worp, antwoord);
				break;
			case "vijfen":
				checkLosseGetallen(5, worp, antwoord);
				break;
			case "zessen":
				checkLosseGetallen(6, worp, antwoord);
				break;
			case "drieDezelfde":
				checkZoveelDezelfden(worp, antwoord);
				break;
			case "vierDezelfde":
				checkZoveelDezelfden(worp, antwoord);
				break;			
			case "kleineStraat":
				checkStraat(worp, antwoord);
				break;
			case "groteStraat":
				checkStraat(worp, antwoord);
				break;
			case "yahtzee":
				checkZoveelDezelfden(worp, antwoord);
				break;			
		}
	}
	
	void checkZoveelDezelfden(ArrayList<Dobbelsteen> worp, String type) {
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		HashMap<Integer, Integer> telling = new HashMap<Integer, Integer>();
		telling.put(1, 0);
		telling.put(2, 0);
		telling.put(3, 0);
		telling.put(4, 0);
		telling.put(5, 0);
		telling.put(6, 0);
		for (Dobbelsteen dobst : worp) {	
			for (Map.Entry waarde : telling.entrySet()) {	
				if (dobst.aantalOgen == (int) waarde.getKey()) {	
					telling.put(dobst.aantalOgen, telling.get(dobst.aantalOgen) + 1);					
				}				
		} 
	}	
		int max = 0;
		for (Map.Entry waarde : telling.entrySet()) {	
			if ((int) waarde.getValue() > max) {
				max = (int) waarde.getValue();
			}
		}
		switch (type) {
			case "drieDezelfde":
				if (max >= 3) {
					System.out.println("Je krijgt er 30 punten bij!");
					totScore.put(type, totScore.get(type) + 30);
					updateTotaleScore();
				} else {
					vakjeWegstrepen(worp, type);
				}
				break;
			case "vierDezelfde":
				if (max >= 4) {
					System.out.println("Je krijgt er 40 punten bij!");
					totScore.put(type, totScore.get(type) + 40);
					updateTotaleScore();
				} else {
					vakjeWegstrepen(worp, type);
				}
				break;
			case "yahtzee":
				if (max == 5) {
					System.out.println("Gefeliciteerd, je hebt yahtzee gegooid! Je krijgt er 50 punten bij.");
					totScore.put(type, totScore.get(type) + 50);
					updateTotaleScore();
				} else {
					vakjeWegstrepen(worp, type);
				}				
				break;			
		}
			
	}
	
	void checkStraat(ArrayList<Dobbelsteen> worp, String type) {
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		boolean een = false;
		boolean twee = false;
		boolean drie = false;
		boolean vier = false;
		boolean vijf = false;
		boolean zes = false;
		for (Dobbelsteen dobst : worp) {
			switch (dobst.aantalOgen) {
			case 1:
				een = true;
				break;
			case 2:
				twee = true;
				break;
			case 3:
				drie = true;
				break;
			case 4:
				vier = true;
				break;
			case 5:
				vijf = true;
				break;
			case 6: 
				zes = true;	
				break;
			} }
		switch (type) {
		case "kleineStraat":
			if (een && twee && drie && vier || twee && drie && vier && vijf || drie && vier && vijf && zes) {
				System.out.println("Je krijgt er 30 punten bij!");
				totScore.put(type, totScore.get(type) + 30);
				updateTotaleScore();
				break;
			} else {
				vakjeWegstrepen(worp, type);
				break;
			}
		case "groteStraat":
			if (een && twee && drie && vier && vijf || twee && drie && vier && vijf && zes) {
				System.out.println("Je krijgt er 40 punten bij!");
				totScore.put(type, totScore.get(type) + 40);
				updateTotaleScore();
				break;
			} else {
				vakjeWegstrepen(worp, type);
				break;
			}
		}
		
	}
	
	
	
	void checkLosseGetallen(int getal, ArrayList<Dobbelsteen> worp, String type) {
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		int teller = 0;
		for (Dobbelsteen dobst : worp) {
			if (dobst.aantalOgen == getal) {
				teller++;
			}		
		}
		int scoreErbij = 0;
		scoreErbij = teller * getal;
		if (scoreErbij == 0) {
			System.out.println("Je hebt geen dobbelsteen met " + getal + " ogen. Wil je dit vakje echt wegstrepen (ja/nee)?");
			String antwoord = Yahtzee.invoeren();
			while (!(antwoord.equals("ja")) && !(antwoord.equals("nee"))) {
				System.out.println("Type ja of nee");
				antwoord = Yahtzee.invoeren();
			}
			if (antwoord.equals("ja")) {
				// key-value pair verwijderen uit hashmap
				totScore.remove(type);
				System.out.println("Je hebt het vakje " + type + " weggestreept en kunt deze niet meer gebruiken.");
			} else if (antwoord.equals("nee")) {
				toonMenu(worp);
			}
		}
		if (scoreErbij >= 1) {
			System.out.print("Je hebt " + teller + " dobbelstenen met " + getal + " ogen. ");
			System.out.println("Je krijgt er dus " + scoreErbij + " punten bij!");
			totScore.put(type, totScore.get(type) + scoreErbij);
			updateTotaleScore();		
		}		
	}
	
	void vakjeWegstrepen(ArrayList<Dobbelsteen> worp, String type) {
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		System.out.println("Je hebt geen " + type + " gegooid. Wil je dit vakje echt wegstrepen (ja/nee)?");
		String antwoord = Yahtzee.invoeren();
		while (!(antwoord.equals("ja")) && !(antwoord.equals("nee"))) {
			System.out.println("Type ja of nee");
			antwoord = Yahtzee.invoeren();
		}
		if (antwoord.equals("ja")) {
			// key-value pair verwijderen uit hashmap
			totScore.remove(type);
			System.out.println("Je hebt het vakje " + type + " weggestreept en kunt deze niet meer gebruiken.");
		} else if (antwoord.equals("nee")) {
			toonMenu(worp);
		}
	}
	
	
	void updateTotaleScore() {
		HashMap<String, Integer> totScore;
		totScore = spelerAanZet.scorekaart.totaalScore;
		int totaal = 0;
		for (Map.Entry vakje : totScore.entrySet()) {
			Integer waarde = (int) vakje.getValue();
			totaal += waarde;			
		}
		spelerAanZet.totaleScore = totaal;
		System.out.println("Totaalscore " + spelerAanZet.naam + ": " + spelerAanZet.totaleScore + " punten.");
	}
	
}
