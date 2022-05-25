package foo.petNanny.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Gardien {

	private String nom;
	private Calendrier calendrier;
	private ArrayList<Race> listeDeRace;
	
	public Gardien(String s) {
		nom = s;
		calendrier = new Calendrier();
		listeDeRace = new ArrayList<Race>();
	}

	public void ajoutRace(Race r) {
		listeDeRace.add(r);
		
	}

	public void ajoutCreneaux(LocalDateTime dd, LocalDateTime df) {
		calendrier.ajoutCrenaux(dd, df);
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public Calendrier getCalendrier() {
		return calendrier;
	}

	public ArrayList<Race> getListeDeRace() {
		return listeDeRace;
	}
	
}
