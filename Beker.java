package yahtzeePackage;

public class Beker {
	Speler speler1;
	Speler speler2;
	Speler spelerAanZet;

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
	
		
	void gooien() {
		System.out.println(spelerAanZet.naam + " is aan de beurt.");
		beurtWisseling();
		System.out.println("Nu is " + spelerAanZet.naam);
		
	
		
	}

}
