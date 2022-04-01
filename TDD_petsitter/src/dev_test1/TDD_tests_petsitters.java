package dev_test1;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TDD_tests_petsitters {

	private Proprietaire P_joe;
	private Animal A_rex;
	private Animal A_bob;
	private Gardien G_helena;
	private Calendrier calendrier;
	
	@Test
	void test1() {
		// La 'Demande de Booking' est refusée si le 'Gardien' n'a pas 'chien' dans la liste d'animaux acceptés.
		P_joe = new Proprietaire("joe");
		A_rex = new Animal("rex", Race.CHIEN);
		P_joe.ajoutAnimal(A_rex);
		
		ArrayList<Race> listeDeRace = new ArrayList<>();
		listeDeRace.add(Race.CHAT);
		calendrier = new Calendrier();
		calendrier.ajoutCrenaux(Date.valueOf("2022-04-01"), Date.valueOf("2022-04-02"));
		G_helena = new Gardien("helena", calendrier, listeDeRace);
		PlageHoraire plageReservation = new PlageHoraire(Date.valueOf("2022-04-01"), Date.valueOf("2022-04-02"));
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, plageReservation));
	}

}
