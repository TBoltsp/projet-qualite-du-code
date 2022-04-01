package dev_test1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendrier {
	
ArrayList<PlageHoraire> liste;
	
	public Calendrier() {
		liste = new ArrayList<>();
	}

	public void ajoutCrenaux(LocalDateTime dateDebut, LocalDateTime dateFin) {
		PlageHoraire crenaux = new PlageHoraire(dateDebut, dateFin);
		liste.add(crenaux);
	}


}
