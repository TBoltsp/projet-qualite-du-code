package dev_TDD;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendrier {

	private ArrayList<PlageHoraire> listeDePlageHoraire;
	
	public Calendrier() {
		listeDePlageHoraire = new ArrayList<>();
	}
	
	public ArrayList<PlageHoraire> getListeDePlageHoraire() {
		return listeDePlageHoraire;
	}
	
	public void ajoutCrenaux(LocalDateTime dd, LocalDateTime df) {
		PlageHoraire crenaux = new PlageHoraire(dd, df);
		listeDePlageHoraire.add(crenaux);
	}
}
