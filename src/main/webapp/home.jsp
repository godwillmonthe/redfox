<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency</title>
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
<body>
<!-- navigation bar -->
    <nav>
      <!-- logo -->
      <a href="#" class="logo">
        <img src="images/logo.png" alt="logo" />
      </a>
      <!-- menu -->
      <ul class="menu">
        <li><a href="#">Home</a></li>
        <li><a href="#">Link 2</a></li>
        <li><a href="#">Link 3</a></li>
        <li><a href="#">Link 4</a></li>
        <li><a href="#">Link 5</a></li>
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
      <h1 class="showcase-heading">New Release</h1>
      
      <ul id="autoWidth" class="cs-hidden">
        <!-- loop box -->
        <% 
        int ar[] = {1, 2, 3, 4, 5};
      	int i, x;
      
      	// iterating over an array
      	for (i = 0; i < ar.length; i++) {

          // accessing each element of array
      	%>
        <a href="movie_details.jsp">
        <li class="item-a">
        	<%-- <%
				String id = request.getParameter("id");
			%> --%>
          <!--showcase-box------------------->
          <div class="showcase-box">
            <img src="getNewReleaseImage.jsp?id= <%= ar[i] %>" />
          </div>
        </li>
        </a>
        <% } %>
      </ul>
    </section>
    <!--latest-movies---------------------->
    <section id="latest">
      <h2 class="latest-heading">Latest Movies</h2>
      <!--slider------------------->
      <ul id="autoWidth2" class="cs-hidden">
        <!--slide-box-1------------------>
        <li class="item-a">
          <div class="latest-box">
            <!--img-------->
            <div class="latest-b-img">
              <img src="getImage.jsp?id=${movie_list.id }" />
            </div>
            <!--text---------->
            <div class="latest-b-text">
              <strong>${movie_list.title} ${movie_list.year}</strong>
              <p>${movie_list.genre} Movie</p>
            </div>
          </div>
        </li>
      </ul>
    </section>
    <!--movies---------------------------->
    <div class="movies-heading">
      <h2>Movies</h2>
    </div>
    <section id="movies-list">
      <!--box-1------------------------>
      <div class="movies-box">
        <!--img------------>
        <div class="movies-img">
          <div class="quality">HDRip</div>
          <img src="images/l-1.jpg" />
        </div>
        <!--text--------->
        <a href="#">
          ${Movie_list.title} | HDRip 1080p
          HD
        </a>
      </div>
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