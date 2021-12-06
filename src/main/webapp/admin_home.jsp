<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency | Admin Home</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lightslider.css" />
    <link rel="stylesheet" href="css/style_add_movie.css"/>
    <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
	<link rel="manifest" href="/site.webmanifest">
    <!-- font awesome link -->
    <script
      src="https://kit.fontawesome.com/c8e4d183c2.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/JQuery3.3.1.js"></script>
    <script src="js/lightslider.js"></script>
  </head>
  <%
	/*Admin active_admin = (Admin)session.getAttribute("active_subscriber");
	if(active_admin == null) {
		response.sendRedirect("admin_login.jsp");
	}*/
%>
<body>
<!-- navigation bar -->
    <nav>
      <!-- logo -->
      <a href="#" class="logo">
        <img src="images/logo.png" alt="logo" />
      </a>
      <c:url var="listallmovies" value="admin">
		<c:param name="option" value="LIST"/>
	</c:url>
	<c:url var="adminHome" value="admin">
	</c:url>
      <!-- menu -->
      <ul class="menu">
        <li><a href="${adminHome}">Home</a></li>
        <li><a href="${listallmovies}">Movie List</a></li>
        <li><a href="add_movie.jsp">Add New Movie</a></li>
        <li><a href="list_admins.jsp">View Admins</a></li>
        <li><a href="logout.jsp?isAdmin=admin">Log Out</a></li>
      </ul>
      <!-- search bar -->
      <div class="search">
        <input type="text" name="search" placeholder="Search Movies" />
        <!-- search-icon -->
        <i class="fas fa-search"></i>
      </div>
    </nav>

</body>
</html>