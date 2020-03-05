
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All </title>
    </head>
    <body>
        <img src="TasteMVC/views/assets/no_image.jpg" alt="noimage.jpg">
        <table style="width:100%">
            <tr>
             <th align="left">ID</th>
             <th align="left">Name</th>
             <th align="left">Address</th>
             <th align="left">Phone</th>
             <th align="left">Email</th>
             <th align="left">Actions</th>
            </tr>
            <c:forEach items="${List}" var="brewery"> 
                <tr>
                    <td>${brewery.id}</td>
                    <td>${brewery.name}</td>
                    <td>${brewery.address1}</td>
                    <td>${brewery.phone}</td>
                    <td>${brewery.email}</td>
                    
                    <td>
                        <%---<a href="\AgentsCRUD\agent\delete?id=${agent.agentId}">Delete</a>----%>
                        <a href="\TasteMVC\taste\display?id=${brewery.id}">Display</a>
                        <a href="\TasteMVC\taste\add">Insert</a>
                        
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
