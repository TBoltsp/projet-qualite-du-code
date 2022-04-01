package dev_test1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Gardien {

	String nom;
	Calendrier calendrier;
	ArrayList<Race> listeDeRace;
	
	public Calendrier getCalendrier() {
		return calendrier;
	}

	public ArrayList<Race> getListeDeRace() {
		return listeDeRace;
	}

	public Gardien(String nom) {
		this.nom = nom;
		calendrier = new Calendrier();
		listeDeRace = new ArrayList<Race>();
	}
	
	public void ajoutRace(Race chien) {
		listeDeRace.add(chien);
	}
	
	public void ajoutCreneaux(LocalDateTime dateDebut, LocalDateTime dateFin) {
		calendrier.ajoutCrenaux(dateDebut, dateFin);
	}
}
