package dev_test1;

import java.time.LocalDateTime;
import java.util.ArrayList;

import testing.Calendrier;
import testing.Race;

public class Gardien {

	String nom;
	Calendrier calendrier;
	ArrayList<Race> listeDeRace;
	
	public Gardien(String nom) {
		this.nom = nom;
		calendrier = new Calendrier();
		listeDeRace = new ArrayList<Race>();
	}
	
	public void addRace(Race race) {
		listeDeRace.add(race);
	}
	
	public void ajoutDisponibilite(LocalDateTime dateDebut, LocalDateTime dateFin) {
		calendrier.ajoutCrenaux(dateDebut, dateFin);
	}
}
