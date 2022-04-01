package testing;
import java.util.ArrayList;

public class Proprietaire {
	private String nom;
	private ArrayList<Animal> listeDAnimaux;

	public ArrayList<Animal> getListeDAnimaux() {
		return listeDAnimaux;
	}

	public Proprietaire(String n) {
		nom = n;
		listeDAnimaux = new ArrayList<Animal>();
	}

	public void ajoutAnimal(Animal a) {
		listeDAnimaux.add(a);
	}
	
}
