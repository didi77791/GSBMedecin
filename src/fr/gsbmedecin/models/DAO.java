package fr.gsbmedecin.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	public List<Departement> getLesDeps(){
		Connect connect = new Connect();
	    Statement stmt = null;
	    List<Integer> departementsDejaVus = new ArrayList<Integer>();
	    List<Departement> departements = new ArrayList<Departement>();
	    try {
			stmt = connect.get().createStatement();
			
			 ResultSet rs = stmt.executeQuery( "SELECT departements.id AS depId, departements.num as depNum, medecins.id AS medId, medecins.nom as medNom, medecins.prenom AS medPrenom, medecins.adresse AS medAdresse, medecins.tel AS medTel, medecins.specialite AS medSpeId, medecins.departement AS medDepId, specialites.id as speId, specialites.nom as speNom FROM departements JOIN medecins ON departements.id = medecins.departement JOIN specialites ON medecins.specialite = specialites.id;" );
		     while ( rs.next() ) {
	        	int idDepartement = rs.getInt("depId");
	           	String numDepartement = rs.getString("depNum");
	
	        	int idMedecin = rs.getInt("medId");
	        	String nomMedecin = rs.getString("medNom");
	        	String prenomMedecin = rs.getString("medPrenom");
	        	String adresseMedecin = rs.getString("medAdresse");
	        	String telMedecin = rs.getString("medTel");
	        	int departementIdMedecin = rs.getInt("medDepId");
	        	int specialiteIdMedecin = rs.getInt("medSpeId");
		        	
	        	int idSpecialite = rs.getInt("speId");
	        	String nomSpecialite = rs.getString("speNom");
	        	
	        	Specialite specialite = new Specialite(idSpecialite, nomSpecialite);
	        	
	        	Medecin medecin = new Medecin(nomMedecin, prenomMedecin, adresseMedecin, telMedecin, departementIdMedecin, numDepartement, specialite, idMedecin);
	        	
		        
		        if(!departementsDejaVus.contains(idDepartement)) {
		    	    List<Medecin> medecins = new ArrayList<Medecin>();
		    	    medecins.add(medecin);
			        Departement departement = new Departement(numDepartement, medecins);
			        departements.add(departement);
			        departementsDejaVus.add(idDepartement);
		        }
		        else {
		        	Departement departement = departements.get(departementsDejaVus.indexOf(idDepartement));
		    	    List<Medecin> medecins = departement.getLesMeds();
		    	    medecins.add(medecin);
		    	    departement = new Departement(departement.getNum(), medecins);
		    	    departements.set(departementsDejaVus.indexOf(idDepartement), departement);
		        }
	        }
	        rs.close();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    connect.close();
	    
	    return departements;
	}
	
	public Departement getLeDep(int id){
		Connect connect = new Connect();
	    Statement stmt = null;
	    List<Integer> departementsDejaVus = new ArrayList<Integer>();
	    Departement departement = null;
	    List<Medecin> medecins = new ArrayList<Medecin>();
	    String numDepartement = "";
	    try {
			stmt = connect.get().createStatement();
			
			 ResultSet rs = stmt.executeQuery( "SELECT departements.id AS depId, departements.num as depNum, medecins.id AS medId, medecins.nom as medNom, medecins.prenom AS medPrenom, medecins.adresse AS medAdresse, medecins.tel AS medTel, medecins.specialite AS medSpeId, medecins.departement AS medDepId, specialites.id as speId, specialites.nom as speNom FROM departements JOIN medecins ON departements.id = medecins.departement JOIN specialites ON medecins.specialite = specialites.id WHERE departements.id='"+id+"';" );
		     while ( rs.next() ) {
	           	numDepartement = rs.getString("depNum");
	
	        	int idMedecin = rs.getInt("medId");
	        	String nomMedecin = rs.getString("medNom");
	        	String prenomMedecin = rs.getString("medPrenom");
	        	String adresseMedecin = rs.getString("medAdresse");
	        	String telMedecin = rs.getString("medTel");
	        	int departementIdMedecin = rs.getInt("medDepId");
	        	int specialiteIdMedecin = rs.getInt("medSpeId");
		        	
	        	int idSpecialite = rs.getInt("speId");
	        	String nomSpecialite = rs.getString("speNom");
	        	
	        	Specialite specialite = new Specialite(idSpecialite, nomSpecialite);
	        	
	        	Medecin medecin = new Medecin(nomMedecin, prenomMedecin, adresseMedecin, telMedecin, departementIdMedecin, numDepartement, specialite, idMedecin);
	        	
	        	medecins.add(medecin);
	        }
	        rs.close();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    connect.close();
	    
	    departement = new Departement(numDepartement, medecins);
	    
	    return departement;
	}
	
	public Pays getNomDeps(){
		Connect connect = new Connect();
	    Statement stmt = null;
	   	Pays pays = null;
	    List<Departement> departements = new ArrayList<Departement>();
	    try {
			stmt = connect.get().createStatement();
			
	        ResultSet rsDepartement = stmt.executeQuery( "SELECT * FROM departements;" );
	        while ( rsDepartement.next() ) {
	        	departements.add(new Departement(rsDepartement.getInt("id"), rsDepartement.getString("num")));
	        }
	        rsDepartement.close();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    connect.close();
	    
	    pays = new Pays(departements);
	    return pays;
	}
	
	public List<Specialite> getNomSpecialites(){
		Connect connect = new Connect();
	    Statement stmt = null;
	    List<Specialite> specialites = new ArrayList<Specialite>();
	    try {
			stmt = connect.get().createStatement();
			
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM specialites;" );
	        while ( rs.next() ) {
	        	specialites.add(new Specialite(rs.getInt("id"), rs.getString("nom")));
	        }
	        rs.close();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    connect.close();
	    return specialites;
	}

}
