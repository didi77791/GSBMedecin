package fr.gsbmedecin.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gsbmedecin.models.DAO;
import fr.gsbmedecin.models.Departement;
import fr.gsbmedecin.models.Pays;

public class RechercheMedecinParDepartement extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
		DAO dao = new DAO();
		Pays pays = dao.getNomDeps();

		ArrayList<Integer> depIds = new ArrayList<Integer>();
		ArrayList<String> depNums = new ArrayList<String>();
		
		for(Departement departement : pays.getLesDeps()) {
			depIds.add(departement.getId());
			depNums.add(departement.getNum());
		}
		
		Integer[] depIdsArray = new Integer[depIds.size()];
		depIdsArray = depIds.toArray(depIdsArray);
		
		request.setAttribute("ids", depIdsArray);
		
		String[] depNumsArray = new String[depNums.size()];
		depNumsArray = depNums.toArray(depNumsArray);
		
		request.setAttribute("nums", depNumsArray);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/recherche-medecin-par-departement.jsp" ).forward( request, response );
	}
	
}
