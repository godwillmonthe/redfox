<%@page import="com.redfox.model.BEAN.Subscriber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency | Recommended Movie</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lightslider.css" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <!-- font awesome link -->
    <script
      src="https://kit.fontawesome.com/c8e4d183c2.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/JQuery3.3.1.js"></script>
    <script src="js/lightslider.js"></script>
  </head>
<%
	Subscriber active = (Subscriber)session.getAttribute("active_subscriber");
	if(active == null) {
		response.sendRedirect("index.jsp");
	}
%>
<body>
<!-- navigation bar -->
    <nav>
      <!-- logo -->
      <a href="#" class="logo">
        <img src="images/logo.png" alt="logo" />
      </a>
      <!-- menu -->
      <ul class="menu">
        <li><a href="home.jsp">Home</a></li>
        <li><a href="#">Link 2</a></li>
        <li><a href="recommended_movies.jsp">Link 3</a></li>
        <li><a href="#">About</a></li>
        <li><a href="logout.jsp">Log Out</a></li>
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