package dev_TDD;

public class Animal {
	
	private String nom;
	private Race race;

	public Animal(String s, Race r) {
		nom = s;
		race = r;
	}
	
	public String getNom() {
		return nom;
	}

	public Race getRace() {
		return race;
	}
}
