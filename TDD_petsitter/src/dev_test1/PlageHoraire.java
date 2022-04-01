package dev_test1;

import java.time.LocalDateTime;

public class PlageHoraire {

	LocalDateTime dateDebut;
	LocalDateTime dateFin;
	boolean estReserve;
	
	public PlageHoraire(LocalDateTime dateDebut, LocalDateTime dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		estReserve = false;
	}
}
