<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Researcher view</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<p style="color: red;">${message}</p>
	<h2>Researcher info</h2>
	<p>ID: ${researcher.getId() }</p>
	<p>Name: ${researcher.getName() }</p>
	<p>Last name: ${researcher.getLastName() }</p>
	<h2>Publications</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Title</th>
		</tr>
		<c:forEach items="${publications}" var="p_i">
			<tr>
				<td><a href="PublicationServlet?id=${p_i.getId()}">${p_i.getId()}</a></td>
				<td>${p_i.getTitle()}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${researcher.getId() == user.getId() || userAdmin}">

		<h3>Update info</h3>
			<form action="UpdateResearcherServlet" method="post">
				<input type="hidden" name="id" value="${researcher.id}" />
				<p>
					Name: <input type="text" name="name" value="${researcher.name}" />
				</p>
				<p>
					Last name: <input type="text" name="last_name" value="${researcher.lastName}" />
				</p>
				<p>
					Email: <input type="text" name="email" value="${researcher.email}" />
				</p>
				<p>
					Password: <input type="text" name="password" value="${researcher.password}" />
				</p>
				<p>
					ScopusUrl: <input type="text" name="scopus_url" value="${researcher.scopusUrl}" />
				</p>
				<p>
					Eid: <input type="text" name="eid" value="${researcher.eid}" />
				</p>
				<button type="submit">Update</button>
			</form>
			
		<h3>Add new publication</h3>
			<form action="CreatePublicationServlet" method="post">
				<input type="hidden" name="first_author" value="${researcher.id}" />
				<p>
					Id: <input type="text" name="id" />
				</p>
				<p>
					Title: <input type="text" name="title" />
				</p>
				<p>
					Authors (separated by semicolon): <input type="text" name="authors" />
				</p>
				<p>
					Eid: <input type="text" name="eid" />
				</p>
				<p>
					Publication name: <input type="text" name="publicaton_name" />
				</p>
				<p>
					Publication date: <input type="text" name="publicaton_date" />
				</p>
				<button type="submit">Create</button>
			</form>
			<form action="GenerateCVServlet" method="get">
				<input type="hidden" name="id" value="${researcher.id}" />
				<button type="submit">Generate CV</button>
			</form>
	</c:if>
</body>
</html>