<%@include file="includes/entete.jsp" %>

<div id="recherche">
	
	<form method="post" action="/SiteMedecins/recherche">
		<label for="departement-select">Choisissez un d�partement : </label>
	
		<select name="departementId" id="departement-select">
        	<% 
            Integer[] ids = (Integer[])request.getAttribute("ids");
            String[] nums = (String[])request.getAttribute("nums");
            for(int i = 0; i<ids.length; i++){
            	%>
            	<option value="<%= ids[i] %>"><%= nums[i] %></option>
            	<% 
            }
            %>
		</select>
		
		<input type="submit" name="recherche" value="Rechercher les m�decins par d�partement" /> 
	
	</form>
	
</div>
<%@include file="includes/pied.jsp" %>