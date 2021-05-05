package fr.gsbmedecin.models;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Departement> departements = dao.getLesDeps();
		for(Departement departement : departements) {
			System.out.println("departement : " + departement.getNum());
			for(Medecin medecin : departement.getLesMeds()){
				System.out.println("nom : " + medecin.getNom());
				System.out.println("specialite : " + medecin.getSpecalite().getNom());
			}
		}
	}

}
