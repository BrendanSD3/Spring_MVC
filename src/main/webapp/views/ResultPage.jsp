<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer Results</title>
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
        </style>
    </head>
    
    <body>
    <%@include file="Header.jsp" %>
        
        <table style="width:100%; ">
            <tr>
             <th align="left"><spring:message code="label.id" /></th>
             <th align="left"><spring:message code="label.name" /></th>
             <th align="left"><spring:message code="label.abv" /></th>
             <th align="left"><spring:message code="label.buyPrice" /></th>
             <th align="left"><spring:message code="label.sellPrice" /></th>
             <th align="left"><spring:message code="label.last_Mod" /></th>
             <th align="left"><spring:message code="label.description" /></th>
             <th align="left"><spring:message code="label.image" /></th>
             <th align="left"><spring:message code="label.catId" /></th>
             <th align="left"><spring:message code="label.styleId" /></th>
             <th align="left"><spring:message code="label.actions"/></th>
            </tr>
             <c:forEach items="${result}" var="result"> 
                <tr>
                    <td>${result.id} </td>
                    <td>${result.name}</td>
                    <td>${result.abv}</td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${result.buyPrice}"/></td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${result.sellPrice}"/></td>
                    <td>${result.lastMod}</td>
                    <td>${result.description}</td>
                    <td><img src="/TasteMVC/images/${result.image}" style="height:50px; width: 50px;" alt="${result.image}"></img></td>
                    <td>${result.catId}</td>
                    <td>${result.styleId}</td>
                    <td><a href="/TasteMVC/taste/Drilldown?id=${result.id}"><spring:message code="label.drilldown" /></a></td>
                    <%---<td>  <a href="\AgentsCRUD\agent\edit?id=${foundagent.agentId}">edit</a></td>---%>
                   
                </tr>
             </c:forEach>
        </table>
    </body>
</html>