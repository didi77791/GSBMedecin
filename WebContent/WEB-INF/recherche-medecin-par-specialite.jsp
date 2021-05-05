<%@include file="includes/entete.jsp" %>

<div id="recherche">
	
	<form method="post" action="/SiteMedecins/recherche">
		<label for="specialite-select">Choisissez une sp�cialit� : </label>
	
		<select name="specialiteId" id="specialite-select">
        	<% 
            Integer[] ids = (Integer[])request.getAttribute("ids");
            String[] noms = (String[])request.getAttribute("noms");
            for(int i = 0; i<ids.length; i++){
            	%>
            	<option value="<%= ids[i] %>"><%= noms[i] %></option>
            	<% 
            }
            %>
		</select>
		
		<input type="submit" name="recherche" value="Rechercher les m�decins par sp�cialit�" /> 
	
	</form>
	
</div>
<%@include file="includes/pied.jsp" %>