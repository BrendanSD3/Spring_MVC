<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All </title>
    

<style>
            thead input {
                width: 100%;
                padding: 3px;
                box-sizing: border-box;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
        <script>
            $(document).ready(function() {
                $('#tableP').DataTable();
            } );
         function Areyousure()
         {
             
  var txt;
  var person = confirm("Are you sure you want to delete this? " );
  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
		window.location.href = "\TasteMVC\taste\delete?id=${brewery.brewid}";
	}
  document.getElementById("demo").innerHTML = txt;

             
             
         }
        </script></head>
        <center><h1>List of Breweries</h1>
            <h3>Message ${message}</h3>

        <table class="display compact hover stripe" id="tableP">
            <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Name</th>
                    <th align="left">City</th>
                    <th align="left">State</th>
                    <th align="left">Country</th>
                    <th align="left">Website</th>
                    <th align="left">Image</th>
                    <th align="left">Email</th>
                    <th align="left">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${List}" var="brewery"> 
                    <tr>
                        <td>${brewery.brewid}</td>
                        <td>${brewery.name}</td>
                        <td>${brewery.city}</td>
                        <td>${brewery.state}</td>
                        <td>${brewery.country}</td>
                        <td>${brewery.website}</td>
                        <td>${brewery.image}</td>
                        <td>${brewery.email}</td>
                        <td>
                            <a href="\TasteMVC\taste\editbrew?id=${brewery.brewid}">Edit</a>
                           <a href="\TasteMVC\taste\display?id=${brewery.brewid}">Display</a>
                           <a href="\TasteMVC\taste\delete?id=${brewery.brewid}" onclick="Areyousure()">Delete</a>
                        <a href="\TasteMVC\taste\add">Insert</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table></center>
    </body>
<%------
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All </title>
    </head>
    <body>
        
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
                        <a href="\delete?id=${}">Delete</a>
                        <a href="\TasteMVC\taste\display?id=${brewery.id}">Display</a>
                        <a href="\TasteMVC\taste\add">Insert</a>
                        
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
---------%>