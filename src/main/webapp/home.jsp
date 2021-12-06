<%@page import="com.redfox.model.BEAN.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.redfox.model.BEAN.Subscriber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency | Home</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lightslider.css" />
    <link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
	<link rel="manifest" href="site.webmanifest">
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
		response.sendRedirect("index.jsp?error=not%20loggedin");
	}
%>
<body>
<!-- navigation bar -->
    <nav>
      <!-- logo -->
      <a href="#" class="logo">
        <img src="images/logo.png" alt="logo" />
      </a>
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
<!-- End of nav bar -->
	<section id="main">
      <!--showcase----------------------->
      <!--heading------------->
      <h1 class="showcase-heading">Showcase Movies</h1>
      
      <ul id="autoWidth" class="cs-hidden">
        <!-- loop box -->
        <c:forEach var="shmovie" items="${New_Release}">
        <li class="item-a">
          <!--showcase-box------------------->
          <div class="showcase-box">
            <img src="getNewReleaseImage.jsp?id= ${shmovie}" />
          </div>
        </li>
        </c:forEach>
        <!-- End of loop box -->
      </ul>
    </section>
    <!--latest-movies---------------------->
    <section id="latest">
      <h2 class="latest-heading">Latest Movies</h2>
      <!--slider------------------->
      <ul id="autoWidth2" class="cs-hidden">
        <!--slide-box-1------------------>
         
      	<c:forEach var="movie" items="${Home_Movies}">
      	<c:url var="details" value="movieController">
			<c:param name="option" value="DISPLAY"/>
			<c:param name="identifier" value="${movie.movie_id}" />
		</c:url>
      	 <a href="${details}">
        <li class="item-a">
          <div class="latest-box">
            <!--img-------->
            <div class="latest-b-img">
              <img src="getImage.jsp?id=${movie.movie_id}" />
            </div>
            <!--text---------->
            <div class="latest-b-text">
              <strong>${movie.title} | ${movie.year_of_release}</strong>
              <p>${movie.genre} Movie</p>
            </div>
          </div>
        </li>
        </a>
        </c:forEach>
      </ul>
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