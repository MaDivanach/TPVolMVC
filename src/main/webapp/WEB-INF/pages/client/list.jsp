<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Client</title>
</head>
<body>
<div class="container">
		<table class="table">
			<tr>
				<th>type</th>
				<th>id</th>
				<th>nom</th>
				<th>prenom</th>
				<th>siret</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.getClass().simpleName }</td>
					<td>${client.id_client }</td>
					<td>${client.nom }</td>
					
					<td>
					<c:if test="${client.getClass().simpleName!='ClientMoral' }">		
						${client.prenom }
					</c:if>
					</td>
					<td>
					<c:if test="${client.getClass().simpleName=='ClientMoral' }">		
						${client.siret }
					</c:if>
					</td>
					<td>editer</td>
					<td>supprimer</td>
				</tr>
			</c:forEach>
		</table>
<!-- 		<a href="./addphysique" class="btn btn-primary">ajout Client Physique</a> -->
<!-- 		<a href="./addmoral" class="btn btn-primary">ajout Client Moral</a> -->
<!-- 		<a href="./addel" class="btn btn-primary">ajout Client El</a> -->
<%-- 					<td><c:choose> --%>
<%-- 							<c:when test="${article.getClass().simpleName=='Dvd'}"> --%>
<!-- 								Dvd -->
<%-- 							</c:when> --%>
<%-- 							<c:otherwise>Blu-ray</c:otherwise> --%>
<%-- 						</c:choose></td> --%>
<%-- 					<td>${article.nbDisques }</td> --%>
<%-- 					<td><c:if --%>
<%-- 							test="${article.getClass().simpleName=='Dvd' && article.bonus}"> --%>
<!-- 							<input type="checkbox" checked="checked" disabled="disabled" /> -->

<%-- 						</c:if></td> --%>



<%-- 					<td><c:if --%>
<%-- 							test="${article.getClass().simpleName=='Blueray' && article.troisD}"> --%>
<!-- 							<input type="checkbox" checked="checked" disabled="disabled" /> -->

<%-- 						</c:if></td> --%>
<%-- 						<td>${article.emprunteur.prenom } ${article.emprunteur.nom }</td> --%>
<%-- 					<td><a href="./delete?id=${article.id}" class="btn btn-danger">supprimer</a></td> --%>
<%-- 					<td><a href="./edit?id=${article.id}" --%>
<!-- 						class="btn btn-primary">edition</a></td> -->
	</div>
</body>
</html>