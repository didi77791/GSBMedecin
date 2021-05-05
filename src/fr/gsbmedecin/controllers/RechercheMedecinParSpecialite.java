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
import fr.gsbmedecin.models.Specialite;

public class RechercheMedecinParSpecialite extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
		DAO dao = new DAO();
		List<Specialite> specialites = dao.getNomSpecialites();

		ArrayList<Integer> speIds = new ArrayList<Integer>();
		ArrayList<String> speNoms = new ArrayList<String>();
		
		for(Specialite specialite : specialites) {
			speIds.add(specialite.getId());
			speNoms.add(specialite.getNom());
		}
		
		Integer[] speIdsArray = new Integer[speIds.size()];
		speIdsArray = speIds.toArray(speIdsArray);
		
		request.setAttribute("ids", speIdsArray);
		
		String[] speNomsArray = new String[speNoms.size()];
		speNomsArray = speNoms.toArray(speNomsArray);
		
		request.setAttribute("noms", speNomsArray);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/recherche-medecin-par-specialite.jsp" ).forward( request, response );
	}
	
}
