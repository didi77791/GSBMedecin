package fr.gsbmedecin.models;

public class Medecin {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private Specialite specialite;
	private int departementId;
	private String departementNum;
	private int id;
	
	public Medecin(String nom, String prenom, String adresse, String tel, int departementId, String departementNum, Specialite specialite, int id) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.specialite = specialite;
		this.departementId = departementId;
		this.departementNum = departementNum;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTel() {
		return tel;
	}

	public Specialite getSpecalite() {
		return specialite;
	}

	public int getDepartementId() {
		return departementId;
	}

	public String getDepartementNum() {
		return departementNum;
	}

	public int getId() {
		return id;
	}
	
	// renvoie 0 si égaux
	public int compareTo(Object t) {
		if(!(t instanceof Medecin)) {
			return 1;
		}
		else {
			Medecin med = (Medecin)t;
			if(this.getId() == med.getId()) {
				return 0;
			}
			return 1;
		}
	}

}
