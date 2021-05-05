<%@include file="includes/entete.jsp" %>

<div id="affichage">
	
	<table>
	    <thead>
	        <tr>
	            <th>Id</th>
	            <th>Nom</th>
	            <th>Prénom</th>
	            <th>Adresse</th>
	            <th>Téléphone</th>
	            <th>Spécialité</th>
	            <th>Département</th>
	        </tr>
	    </thead>
	    <tbody>
        	<% 
            Integer[] ids = (Integer[])request.getAttribute("ids");
            String[] noms = (String[])request.getAttribute("noms");
            String[] prenoms = (String[])request.getAttribute("prenoms");
            String[] adresses = (String[])request.getAttribute("adresses");
            String[] tels = (String[])request.getAttribute("tels");
            String[] specialites = (String[])request.getAttribute("specialites");
            String[] departements = (String[])request.getAttribute("departements");
            for(int i = 0; i<ids.length; i++){
            	%>
	       		<tr>
	            	<td><%= ids[i] %></td>
	            	<td><%= noms[i] %></td>
	            	<td><%= prenoms[i] %></td>
	            	<td><%= adresses[i] %></td>
	            	<td><%= tels[i] %></td>
	            	<td><%= specialites[i] %></td>
	            	<td><%= departements[i] %></td>
	       		</tr>
            	<% 
            }
            %>
	    </tbody>
	</table>
	
</div>
<%@include file="includes/pied.jsp" %>