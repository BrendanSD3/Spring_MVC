<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="taste.title" /></title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <h1><spring:message code="welcome.message"/></h1>
         <h2> <a href="\TasteMVC\taste\search"><spring:message code="label.searchforBeer"/></a></h2>
    </body>
</html>