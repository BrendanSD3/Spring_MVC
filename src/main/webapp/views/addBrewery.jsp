<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
    </head>
  
        <h3>Enter The Brewery Details!</h3>
        
        <form:form method="POST" action="/TasteMVC/taste/addBrewery" modelAttribute="brew">
     
            <table>
                <tr>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id" required='true'/></td> 
               </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                    <form:errors path="name"/>
                </tr>
                <tr>
                    <td><form:label path="address1">Address 1</form:label></td>
                    <td><form:input path="address1"/></td>
                </tr>
                <tr>
                    <td><form:label path="address2">Address 2</form:label></td>
                    <td><form:input path="address2"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city"/></td>
                </tr>
               <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td><form:input path="state"/></td>
                </tr>
                <tr>
                    <td><form:label path="code">Code</form:label></td>
                    <td><form:input path="code"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                    <td><form:label path="phone">Phone</form:label></td>
                    <td><form:input path="Phone"/></td>
                </tr>
                <tr>
                    <td><form:label path="website">Website</form:label></td>
                    <td><form:input path="website"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="creditLimit">Credit_Limit</form:label></td>
                    <td><form:input path="creditLimit"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <%----<tr>
                    <td><form:label path="latitude">Latitude</form:label></td>
                    <td><form:input path="latitude"/></td>
                </tr>
                  <tr>
                    <td><form:label path="longitude">Longitude</form:label></td>
                    <td><form:input path="longitude"/></td>
                </tr>----%>
                <tr>
                    <td><input type="submit" value="Submit!"/></td>
                </tr>
            </table>
        </form:form>
    
	
</html>