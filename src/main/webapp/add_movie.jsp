<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:url var="addmovie" value="movieController">
		<c:param name="option" value="ADD"/>
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
    <section class="registration">
	    <div class="container">
	    	<div class="title">Add New Movie</div>
	    	<form action="${addmovie}" method="POST" enctype="multipart/form-data" autocomplete="off">
	    		<span style="color: green;">${message}</span>
	    		<div class="movie-details">
	    			<div class="input-box">
	    				<span class="details">Title</span>
	    				<input type="text" name="movie_title" placeholder="Enter movie title.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Description</span>
	    				<input type="text" name="movie_desc" placeholder="Enter movie description.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Director</span>
	    				<input type="text" name="movie_director" placeholder="Enter movie director.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Cast 1</span>
	    				<input type="text" name="movie_cast_one" placeholder="Enter movie cast one.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Cast 2</span>
	    				<input type="text" name="movie_cast_two" placeholder="Enter movie cast two.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Cast 3</span>
	    				<input type="text" name="movie_cast_three" placeholder="Enter movie cast three.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Genre</span>
	    				<input type="text" name="movie_genre" placeholder="Enter movie genre.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Trailer Link</span>
	    				<input type="text" name="movie_trailer_link" placeholder="Enter movie trailer link.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Year Of Release</span>
	    				<input type="text" name="movie_year_of_release" placeholder="Enter year of release.." required>
	    			</div>
	    			<div class="input-box">
	    				<span class="details">Thumbnail</span>
	    				<input type="file" name="movie_thumbnail">
    				</div>
	    		</div>
	    		<div class="button">
	    			<input type="submit" value="Add Movie"/>
	    		</div>
	    	</form>
	    </div>
	</section>
</body>
</html>