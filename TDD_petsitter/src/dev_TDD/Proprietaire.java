package dev_TDD;

// import java.util.ArrayList;

public class Proprietaire {

	private String nom;
	private Animal animal;
	
	public Proprietaire(String s) {
		nom = s;
	}

	public void ajoutAnimal(Animal a) {
		animal = a;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Animal getAnimal() {
		return animal;
	}
}
