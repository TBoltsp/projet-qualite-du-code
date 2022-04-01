package dev_test1;

import java.util.ArrayList;

public class Proprietaire {

	private String nom;
	private ArrayList<Animal> listeDAnimaux;
	
	public Proprietaire(String nom) {
		this.nom = nom;
		listeDAnimaux = new ArrayList<Animal>();
	}

	public void ajoutAnimal(Animal animal) {
		listeDAnimaux.add(animal);
	}
	
	public ArrayList<Animal> getListeDAnimaux() {
		return listeDAnimaux;
	}
}
