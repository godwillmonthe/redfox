<%@page import="com.redfox.model.BEAN.Subscriber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>RedFox | Movie List</title>
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
		response.sendRedirect("index.jsp?error=not%20logged%20in");
	}
%>
<body>
	<nav>
      <!-- logo -->
      <a href="#" class="logo">
        <img src="images/logo.png" alt="logo" />
      </a>
      <!-- menu -->
		<c:url var="listmovies" value="movieController">
			<c:param name="option" value="LOAD"/>
		</c:url>
		<c:url var="home" value="movieController">
		</c:url>
      <!-- menu -->
      <ul class="menu">
        <li><a href="${home}">Home</a></li>
        <li><a href="${listmovies}">View Movies</a></li>
        <li><a href="recommended_movies.jsp">Recommended Movies</a></li>
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
	<!--movies---------------------------->
    <div class="movies-heading">
      <h2>Movies</h2>
    </div>
    <section id="movies-list">
    	<c:forEach var="movie_list" items="${Movie_List}">
      	<c:url var="details" value="movieController">
			<c:param name="option" value="DISPLAY"/>
			<c:param name="identifier" value="${movie_list.movie_id}" />
		</c:url>
      <!--box-1------------------------>
      <div class="movies-box">
        <!--img------------>
        <div class="movies-img">
          <div class="quality">HDRip</div>
          <img src="getImage.jsp?id=${movie_list.movie_id}" />
        </div>
        <!--text--------->
        <a href="${details}">
          ${movie_list.title} | HDRip 1080p
          HD
        </a>
      </div>
      </c:forEach>
    </section>
    <script>
      $(document).ready(function () {
        $("#autoWidth,#autoWidth2").lightSlider({
          autoWidth: true,
          loop: true,
          onSliderLoad: function () {
            $("#autoWidth,#autoWidth2").removeClass("cS-hidden");
          },
        });
      });
    </script>
</body>
</html>