package dev_test1;

public class Booking {

	public static boolean demandeBooking(Proprietaire proprietaire, Gardien gardien, PlageHoraire crenaux) {
		
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
		if (result) {
			boolean bonCrenaux = false;
			for(int i = 0; i < gardien.getCalendrier().getListe().size(); i++) {
				if(gardien.getCalendrier().getListe().get(i).equals(crenaux)) {
					//Si le crenaux n'est pas réservé
					if(!gardien.getCalendrier().getListe().get(i).isEstReserve()) {
						gardien.getCalendrier().getListe().get(i).setEstReserve(true);
						bonCrenaux = true;
						break;
					}
				}
			}
			if (!bonCrenaux) {
				result = false;
			}
		}
		
		return result;
	}

}
