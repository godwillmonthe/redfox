<%@page import="com.redfox.model.BEAN.Subscriber"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RedFox Agency | Movie Details</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lightslider.css" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/details.css" />
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
    <div id="columns" class="row">
      <div class="column">
        <div class="img-container">
          <img
            src="getImage.jsp?id=${theMovie.movie_id}"
            alt="iron man image"
            width="500"
            height="700"
          />
        </div>
      </div>
      <div class="column">
        <div class="movie-description">
          <span>Movie Details</span>
          <h1>${theMovie.title}</h1>
          <span>Description</span>
          <p>
            ${theMovie.description}
          </p>
        </div>

        <!-- Product Configuration -->
        <div class="movie-configuration">
          <!-- Product Color -->
          <div class="movie-cast">
            <span>Director</span>
				
            <div class="cast-names">
            <p>${theMovie.director}</p>
            </div>
          </div>
          <div class="movie-cast">
            <span>Cast</span>
            <div class="cast-names">
            	<p>${theMovie.cast_one}</p>
				<p>${theMovie.cast_two}</p>
				<p>${theMovie.cast_three}</p>
            </div>
          </div>
          <div class="movie-rating">
            <span>Rating</span>
            <div class="cast-names">
            	<div class="con">
					<i class="fa fa-star" id="s1"></i>
					<i class="fa fa-star" id="s2"></i>
					<i class="fa fa-star" id="s3"></i>
					<i class="fa fa-star" id="s4"></i>
					<i class="fa fa-star" id="s5"></i>
				</div>
            </div>
          </div>

          <!-- movie genre -->
          <div class="movie-genre">
            <span>Genre</span>

            <div class="cable-choose">
              <span>${theMovie.genre}</span>
            </div>

            <a href="#">Associated Cinemas</a>
          </div>
        </div>

        <!-- Product Pricing -->
        <div class="product-price">
          <span>P90.00</span>
          <a href="#" class="cart-btn">Buy ticket</a>
        </div>
      </div>
    </div>
    <div class="trailer-container">
      <h1>Watch Movie Trailer</h1>
      <div class="flexible-container">
        <iframe
          width="916"
          height="515"
          src="${theMovie.trailer_link}"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
      </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function() {
			$("#s1").click(function() {
				$(".fa-star").css("color", "black")
				$("#s1").css("color", "yellow")
			})
		});
		$(document).ready(function() {
			$("#s2").click(function() {
				$(".fa-star").css("color", "black")
				$("#s1, #s2").css("color", "yellow")
			})
		});
		$(document).ready(function() {
			$("#s3").click(function() {
				$(".fa-star").css("color", "black")
				$("#s1, #s2, #s3").css("color", "yellow")
			})
		});
		$(document).ready(function() {
			$("#s4").click(function() {
				$(".fa-star").css("color", "black")
				$("#s1, #s2, #s3, #s4").css("color", "yellow")
			})
		});
		$(document).ready(function() {
			$("#s5").click(function() {
				$(".fa-star").css("color", "black")
				$(".fa-star").css("color", "yellow")
			})
		});
	</script>
</body>
</html>