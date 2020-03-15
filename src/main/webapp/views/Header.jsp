<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div><spring:message code="label.changelanguage"/>
    <!---<select name="locale" onchange="location=this.value">---->
       <a href="/TasteMVC/taste/search?language=en_IE">English</a>
        <a href="/TasteMVC/taste/search?language=fr_FR">French</a>
    </select>
</div>


