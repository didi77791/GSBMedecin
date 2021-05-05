package fr.gsbmedecin.models;

import java.util.List;

public class Pays {
	
	private List<Departement> deps;
	
	public Pays() {
		DAO dao = new DAO();
		deps = dao.getLesDeps();
	}
	
	public Pays(List<Departement> deps) {
		this.deps = deps;
	}
	
	public List<Departement> getLesDeps() {
		return deps;
	}
	
	public Departement getLeDep(String num) {
		for(Departement dep : getLesDeps()) {
			if(dep.getNum().equalsIgnoreCase(num)) {
				return dep;
			}
		}
		return null;
	}

}
