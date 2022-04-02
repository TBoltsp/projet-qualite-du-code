package dev_TDD;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Booking {

	public static boolean demandeBooking(Proprietaire p, Gardien g, LocalDateTime dd, LocalDateTime df) {
		// verification race compatible
		if (!raceCompatible(p, g)) {
			return false;
		}
		// creation nouvelle date reservation
		PlageHoraire reservation = new PlageHoraire(dd, df);
		// verification creneaux compatible
		return creneauxCompatible(g, reservation);
	}

	private static boolean creneauxCompatible(Gardien g, PlageHoraire plageH) {
		boolean creneaux = false;
		ArrayList<PlageHoraire> calendrier = g.getCalendrier().getListeDePlageHoraire();
		for (Iterator<PlageHoraire> iter = calendrier.iterator(); iter.hasNext();) {
			PlageHoraire type = iter.next();
			// verification pas de collision
			if (!type.collision(plageH)) {
				// verification creneaux equals
				if (type.equals(plageH)) {
					// verification calendrier non reserve
					if (!calendrier.get(calendrier.indexOf(type)).getEstReserve()) {
						// reservation du creneaux
						calendrier.get(calendrier.indexOf(type)).setEstReserve(true);
						creneaux = true;
					}
				}
			}
		}
		return creneaux;
	}

	private static boolean raceCompatible(Proprietaire p, Gardien g) {
		boolean race = false;
		for (Iterator<Race> iter = g.getListeDeRace().iterator(); iter.hasNext();) {
			Race type = iter.next();
			if (type.equals(p.getAnimal().getRace())) {
				race = true;
				break;
			}
		}
		return race;
	}

}
