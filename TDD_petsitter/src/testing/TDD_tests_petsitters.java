package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TDD_tests_petsitters {

	private Proprietaire P_joe;
	private Animal A_rex;
	private Animal A_bob;
	private Gardien G_helena;
	private Calendrier calendrier;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	@Test
	void test1() {
		// La 'Demande de Booking' est refusée si le 'Gardien' n'a pas 'chien' dans la liste d'animaux acceptés.
		A_rex = new Animal("rex", Race.CHIEN);
		
		P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void test2() {
		//La 'Demande de Booking' est acceptée si le 'Gardien' a le 'chien' dans la liste d'animaux acceptés.
		//A ce moment là, le 'Calendrier' du 'Gardien' est modifié, et la date (plage de date, début et fin) est marquée comme occuppée.
		A_rex = new Animal("rex", Race.CHIEN);
		
		P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void test3() {
		//La 'Demande de Booking' est refusée si le 'Gardien' n'est pas disponible à la date demandée en fonction de son 'Calendrier'
		A_rex = new Animal("rex", Race.CHIEN);
		
		P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 8, 0, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 9, 30, 0);
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}

}
