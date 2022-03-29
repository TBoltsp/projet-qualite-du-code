import static org.junit.jupiter.api.Assertions.*;

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
		
		P_joe = new Proprietaire("joe");
		A_rex = new Animal("rex", Race.CHIEN);
		P_joe.ajoutAnimal(A_rex);
		
		ArrayList<Race> listeDeRace = new ArrayList<>();
		listeDeRace.add(Race.CHAT);
		calendrier = new Calendrier();
		G_helena = new Gardien("helena", calendrier, listeDeRace);
		
		assertFalse(q);
	}
	
	@Test
	void test2() {
		fail("Not yet implemented");
	}
	
	@Test
	void test3() {
		fail("Not yet implemented");
	}

}
