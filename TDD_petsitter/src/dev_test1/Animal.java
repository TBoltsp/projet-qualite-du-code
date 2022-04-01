package dev_test1;

public class Animal {

	private String nom;
	private Race race;
	
	public Race getRace() {
		return race;
	}

	public Animal(String nom, Race race) {
		this.nom = nom;
		this.race = race;
	}
}
