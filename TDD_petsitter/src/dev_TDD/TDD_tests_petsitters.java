package dev_TDD;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TDD_tests_petsitters {
	
	@Test
	void testBooking1() {
		// La 'Demande de Booking' est refusee si le 'Gardien' n'a pas 'chien' dans la liste d'animaux acceptes.
		Animal A_rex = new Animal("rex", Race.CHIEN);
		
		Proprietaire P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		Gardien G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void testBooking2() {
		//La 'Demande de Booking' est acceptee si le 'Gardien' a le 'chien' dans la liste d'animaux acceptes.
		//A ce moment la, le 'Calendrier' du 'Gardien' est modifie, et la date (plage de date, debut et fin) est marquee comme occuppee.
		Animal A_rex = new Animal("rex", Race.CHIEN);
		
		Proprietaire P_joe = new Proprietaire("joe");
		P_joe.ajoutAnimal(A_rex);
		
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		Gardien G_helena = new Gardien("helena");
		G_helena.ajoutRace(Race.CHAT);
		G_helena.ajoutRace(Race.CHIEN);
		G_helena.ajoutCreneaux(dateDebut, dateFin);
		
		assertFalse(G_helena.getCalendrier().getListeDePlageHoraire().get(0).getEstReserve());
		assertTrue(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
		assertTrue(G_helena.getCalendrier().getListeDePlageHoraire().get(0).getEstReserve());

	}
	
	@Test
	void testBooking3() {
		//La 'Demande de Booking' est refuse si le 'Gardien' n'est pas disponible a la date demandee en fonction de son 'Calendrier'
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
	
	@Test
	void testBooking3QuestionFinCollision() {
		//La 'Demande de Booking' est refuse si le 'Gardien' n'est pas disponible a la date demandee en fonction de son 'Calendrier'
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
		dateFin = LocalDateTime.of(2022, 04, 01, 11, 15, 0);
		assertFalse(Booking.demandeBooking(P_joe, G_helena, dateDebut, dateFin));
	}
	
	@Test
	void testPlageHoraire1() {
		// redefinir equals de PlageHoraire sur les champs LocalDateTime uniquement
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertTrue(ph1.equals(ph2));
	}
	
	@Test
	void testPlageHoraire2() {
		// not equals si un element d'une date est different
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);

		dateFin = LocalDateTime.of(2022, 04, 01, 14, 30, 0);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertFalse(ph1.equals(ph2));
	}
	
	@Test
	void testPlageHoraire3() {
		// trows IllegalArgumentException quand dateDebut superieur a dateFin
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 9, 30, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new PlageHoraire(dateDebut, dateFin);
	  });
	}
	
	@Test
	void testPlageHoraireCollisionDebut() {
		// collision au debut
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 9, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 11, 30, 0);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertTrue(ph1.collision(ph2));
	}
	
	@Test
	void testPlageHoraireCollisionFin() {
		// collision au fin
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 12, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 17, 30, 0);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertTrue(ph1.collision(ph2));
	}
	
	@Test
	void testPlageHoraireCollisionRecouvrement() {
		// collision par recouvrement de l'horaire
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2022, 04, 01, 8, 30, 0);
		dateFin = LocalDateTime.of(2022, 04, 01, 17, 30, 0);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertTrue(ph1.collision(ph2));
	}
	
	@Test
	void testPlageHoraireCollisionNegatif() {
		// non collision 
		LocalDateTime dateDebut = LocalDateTime.of(2022, 04, 01, 10, 30, 0);
		LocalDateTime dateFin = LocalDateTime.of(2022, 04, 01, 15, 30, 0);
		PlageHoraire ph1 = new PlageHoraire(dateDebut, dateFin);
		
		dateDebut = LocalDateTime.of(2021, 04, 01, 8, 30, 0);
		dateFin = LocalDateTime.of(2021, 04, 01, 17, 30, 0);
		PlageHoraire ph2 = new PlageHoraire(dateDebut, dateFin);
		
		assertFalse(ph1.collision(ph2));
	}

}
