package dev_test1;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;

public class Booking {

	public static boolean demandeBooking(Proprietaire proprietaire, Gardien gardien, LocalDateTime dateDebut,
			LocalDateTime dateFin) {
		
		boolean result = true;
		
		//check la liste d'animaux
		for(int i = 0; i < proprietaire.getListeDAnimaux().size(); i++) {
			boolean dansLaListe = false;
			for(int j = 0; j < gardien.getListeDeRace().size(); j++) {
				if(proprietaire.getListeDAnimaux().get(i).getRace() == gardien.getListeDeRace().get(j)) {
					dansLaListe = true;
					break;
				}
			}
			if (!dansLaListe) {
				result = false;
				break;
			}
		}
				//check les creneaux
				//update le creneaux si le creaneaux est disponible et libre
				//		renvoie true dans ce cas
				//		sinon renvoie false
		
		return result;
	}

}
