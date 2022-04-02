package dev_test2;

import java.util.ArrayList;

public class Proprietaire {
	
	private String nom;
	private ArrayList<Animal> listeDAnimaux;

	public Proprietaire(String s) {
		nom = s;
		listeDAnimaux = new ArrayList<Animal>();
	}

	public void ajoutAnimal(Animal a) {
		listeDAnimaux.add(a);
	}
	
	public String getNom() {
		return nom;
	}

	public ArrayList<Animal> getListeDAnimaux() {
		return listeDAnimaux;
	}
}
