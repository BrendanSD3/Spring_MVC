<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
         <title>Beer Search</title>
        
    </head>
    <body>
        <h1><spring:message code="label.searchforBeer"/></h1>
        <form:form method="POST" action="/TasteMVC/taste/searchbeer" modelAttribute="Beer">
        <form:input path="name" placeholder="Search for a beer"/>
        <button type="submit" value="Submit!"><spring:message code="label.submit"/></button>
        
        </form:form>
        
    </body>
</html>
