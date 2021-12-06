<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logging out..</title>
</head>
<body>
 <%
 	String isAdmin = request.getParameter("isAdmin");
 	session.invalidate();
 	session = request.getSession(false);
 	if(isAdmin == null) {
 		response.sendRedirect("index.jsp");
 	} else if(isAdmin.equals("admin")) {
 		response.sendRedirect("admin_login.jsp");
 	}
 %>
</body>
</html>