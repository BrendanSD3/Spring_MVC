<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="taste.title" /></title>
        <style>
        table,th,tr,td{    
            border:1px solid black;
            border-collapse: collapse;
        }
        th{
            color:background;
            
        }
        th, td {
            padding: 15px;
            }
            input:invalid {
  color: red;
}
        </style>
    </head>
    
    <body>
    <%@include file="Header.jsp" %>
        
        <table style="width:100%; ">
            <tr>
             <th align="left"><spring:message code="label.id" /></th>
             <th align="left"><spring:message code="label.name" /></th>
             <th align="left"><spring:message code="label.abv" /></th>
             <th align="left"><spring:message code="label.last_Mod" /></th>
             <th align="left"><spring:message code="label.description" /></th>
             <th align="left"><spring:message code="label.image" /></th>
             <th align="left"><spring:message code="label.catname" /></th>
             <th align="left"><spring:message code="label.stylename" /></th>
             <th align="left"><spring:message code="label.buyPrice" /></th>
             <th align="left"><spring:message code="label.sellPrice" /></th>
             
            </tr>
            
                <tr>
                    
                    
                    <td>${beers.id} </td>
                    <td>${beers.name}</td>
                    <td>${beers.abv}</td>
                    
                    <td>${beers.lastMod}</td>
                    <td>${beers.description}</td>
                    <td><img src="/TasteMVC/images/${beers.image}" style="height:50px; width: 50px;" alt="${beers.image}"></img></td>
                    <td>${catname}</td>
                    <td>${stylename}</td>
                   <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${beers.buyPrice}"/></td>
                   
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${beers.sellPrice}"/></td>
            
                    <%---<td>  <a href="\AgentsCRUD\agent\edit?id=${foundagent.agentId}">edit</a></td>---%>
                   
                </tr>
                </table>
                    
                    <form:form method="POST" action="/TasteMVC/taste/changesellprice?id=${beers.id}" modelAttribute="price">
                        
                        <label for="price"><spring:message code="label.enterPercentage" /></label>
                        <input type="text" name="price" maxlength="4" max="100" pattern="[+-?0-9]+([\.][0-9]{0,2})?">
                        <button type="submit" value="Submit!"><spring:message code="label.submit"/></button>
        
                        
                    </form:form>
        
                    
                    
    </body>
</html>