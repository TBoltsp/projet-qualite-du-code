package dev_test1;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import testing.Animal;
import testing.Booking;
import testing.Calendrier;
import testing.Gardien;
import testing.PlageHoraire;
import testing.Proprietaire;
import testing.Race;

class TDD_tests_petsitters {

	@Test
	void test1() {
		// La 'Demande de Booking' est refusée si le 'Gardien' n'a pas 'chien' dans la liste d'animaux acceptés.
		Animal A_rex = new Animal("rex", Race.CHIEN);
		
		Proprietaire P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		Gardien G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void test2() {
		//La 'Demande de Booking' est acceptée si le 'Gardien' a le 'chien' dans la liste d'animaux acceptés.
		//A ce moment là , le 'Calendrier' du 'Gardien' est modifié, et la date (plage de date, début et fin) est marquée comme occuppée.
		Animal A_rex = new Animal("rex", Race.CHIEN);
		
		Proprietaire P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		Gardien G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void test3() {
		//La 'Demande de Booking' est refusée si le 'Gardien' n'est pas disponible à  la date demandée en fonction de son 'Calendrier'
		Animal A_rex = new Animal("rex", Race.CHIEN);
		
		Proprietaire P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		Gardien G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 8, 0, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 9, 30, 0);
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}

}
