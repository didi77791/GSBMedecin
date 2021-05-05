package fr.gsbmedecin.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gsbmedecin.models.DAO;
import fr.gsbmedecin.models.Departement;
import fr.gsbmedecin.models.Medecin;

public class Recherche extends HttpServlet {
	
	public void doPost( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
		String departementId = request.getParameter("departementId");
		String specialiteId = request.getParameter("specialiteId");

		ArrayList<Integer> medecinsIds = new ArrayList<Integer>();
		ArrayList<String> medecinsNoms = new ArrayList<String>();
		ArrayList<String> medecinsPrenoms = new ArrayList<String>();
		ArrayList<String> medecinsAdresses = new ArrayList<String>();
		ArrayList<String> medecinsTels = new ArrayList<String>();
		ArrayList<String> medecinsSpecialites = new ArrayList<String>();
		ArrayList<String> medecinsDepartements = new ArrayList<String>();
		
		if(departementId != null) {
			DAO dao = new DAO();
			Departement departement = dao.getLeDep(Integer.parseInt(departementId));
			for(Medecin medecin : departement.getLesMeds()) {
				medecinsIds.add(medecin.getId());
				medecinsNoms.add(medecin.getNom());
				medecinsPrenoms.add(medecin.getPrenom());
				medecinsAdresses.add(medecin.getAdresse());
				medecinsTels.add(medecin.getTel());
				medecinsSpecialites.add(medecin.getSpecalite().getNom());
				medecinsDepartements.add(medecin.getDepartementNum());
			}
			
			
		}
		else if (specialiteId != null) {
			DAO dao = new DAO();
			List<Departement> departements = dao.getLesDeps();
			
			for(Departement departement : departements) {
				for(Medecin medecin : departement.getLesMeds()) {
					if(medecin.getSpecalite().getId() == Integer.parseInt(specialiteId)) {
						medecinsIds.add(medecin.getId());
						medecinsNoms.add(medecin.getNom());
						medecinsPrenoms.add(medecin.getPrenom());
						medecinsAdresses.add(medecin.getAdresse());
						medecinsTels.add(medecin.getTel());
						medecinsSpecialites.add(medecin.getSpecalite().getNom());
						medecinsDepartements.add(medecin.getDepartementNum());
					}
				}
			}
		}
		else {
			DAO dao = new DAO();
			List<Departement> departements = dao.getLesDeps();
			
			for(Departement departement : departements) {
				for(Medecin medecin : departement.getLesMeds()) {
					medecinsIds.add(medecin.getId());
					medecinsNoms.add(medecin.getNom());
					medecinsPrenoms.add(medecin.getPrenom());
					medecinsAdresses.add(medecin.getAdresse());
					medecinsTels.add(medecin.getTel());
					medecinsSpecialites.add(medecin.getSpecalite().getNom());
					medecinsDepartements.add(medecin.getDepartementNum());
				}
			}
		}
		
		Integer[] medecinsIdsArray = new Integer[medecinsIds.size()];
		medecinsIdsArray = medecinsIds.toArray(medecinsIdsArray);
		request.setAttribute("ids", medecinsIdsArray);
		
		String[] medecinsNomsArray = new String[medecinsNoms.size()];
		medecinsNomsArray = medecinsNoms.toArray(medecinsNomsArray);
		request.setAttribute("noms", medecinsNomsArray);
		
		String[] medecinsPrenomsArray = new String[medecinsPrenoms.size()];
		medecinsPrenomsArray = medecinsPrenoms.toArray(medecinsPrenomsArray);
		request.setAttribute("prenoms", medecinsPrenomsArray);
		
		String[] medecinsAdressesArray = new String[medecinsAdresses.size()];
		medecinsAdressesArray = medecinsAdresses.toArray(medecinsAdressesArray);
		request.setAttribute("adresses", medecinsAdressesArray);
		
		String[] medecinsTelsArray = new String[medecinsTels.size()];
		medecinsTelsArray = medecinsTels.toArray(medecinsTelsArray);
		request.setAttribute("tels", medecinsTelsArray);
		
		String[] medecinsSpecialitesArray = new String[medecinsSpecialites.size()];
		medecinsSpecialitesArray = medecinsSpecialites.toArray(medecinsSpecialitesArray);
		request.setAttribute("specialites", medecinsSpecialitesArray);
		
		String[] medecinsDepartementsArray = new String[medecinsDepartements.size()];
		medecinsDepartementsArray = medecinsDepartements.toArray(medecinsDepartementsArray);
		request.setAttribute("departements", medecinsDepartementsArray);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/affichage-medecins.jsp" ).forward( request, response );
	}
	
}
