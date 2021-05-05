package fr.gsbmedecin.models;

import java.util.List;

public class Departement {
	
	private int id;
	private String num;
	private List<Medecin> lesMeds;
	
	public Departement(String num, List<Medecin> lesMeds) {
		this.num = num;
		this.lesMeds = lesMeds;
	}
	
	public Departement(int id, String num) {
		this.id = id;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public String getNum() {
		return num;
	}

	public List<Medecin> getLesMeds() {
		return lesMeds;
	}
	
	// renvoie 0 si égaux
	public int compareTo(Object t) {
		if(!(t instanceof Departement)) {
			return 1;
		}
		else {
			Departement dep = (Departement)t;
			if(this.getNum().equalsIgnoreCase(dep.getNum())) {
				return 0;
			}
			return 1;
		}
	}

}
