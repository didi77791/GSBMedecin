package fr.gsbmedecin.models;

public class Specialite {
	
	private int id;
	private String nom;
	
	public Specialite(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

}
