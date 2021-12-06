<%@page import="com.redfox.model.BEAN.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency | New Movie</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lightslider.css" />
    <link rel="stylesheet" href="css/style_register.css"/>
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
	/*Employee active = (Employee)session.getAttribute("active_subscriber");
	if(active == null) {
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
      <!-- menu -->
      <ul class="menu">
        <li><a href="admin_home.jsp">Home</a></li>
        <li><a href="admin_movie_list.jsp">Movie List</a></li>
        <li><a href="add_movie.jsp">Add New Movie</a></li>
        <li><a href="list_admins.jsp">View Admins</a></li>
        <li><a href="logout.jsp">Log Out</a></li>
      </ul>
      <!-- search bar -->
      <div class="search">
        <input type="text" name="search" placeholder="Search Movies" />
        <!-- search-icon -->
        <i class="fas fa-search"></i>
      </div>
    </nav>
	<div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h3>Add New Employee</h3>
            <p>Fill in all the input fields to create account.</p>
          </div>
        </div>
        <form class="login-form" action=addadmin method=post>
          <input type="text" name=firstname placeholder="Firstname"/>
          <input type="text" name=lastname placeholder="Lastname"/>
          <input type="text" name=email placeholder="Email Address"/>
          <input type="password" name=password placeholder="Password"/>
          <label for="">
          	Admin
          </label>
          <input type="radio" name="isAdmin" value="Admin"/>
          <label for="">Staff</label>
          <input type="radio" name="isAdmin" value="Staff"/>
          <input class=button type=submit name=submit value=Register />
        </form>
      </div>
    </div>
</body>
</html>