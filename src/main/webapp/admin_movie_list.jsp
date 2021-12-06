<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Movies</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.bootstrap.min.css">
    <link rel="stylesheet" href=" https://cdn.datatables.net/responsive/2.2.6/css/responsive.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
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
/*Admin active = (Admin)session.getAttribute("active_admin");
if(active == null) {
	response.sendRedirect("admin_login.jsp");	
}*/
%>
<body>
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
    <br>
    <div class="container">
        <table id="movie_list" class="table table-striped table-bordered nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>Movie ID</th>
                    <th>Title</th>
                    <th>Director</th>
                    <th>Cast 1</th>
                    <th>Cast 2</th>
                    <th>Cast 3</th>
                    <th>Genre</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    <th>Trailer Link</th>
                    <th>Year Of Release</th>
                </tr>
            </thead>
            <tbody>
	            <c:forEach var="mov" items="${admin_movie_List}">
	            	<c:url var="editlink" value="admin">
						<c:param name="identifier" value="${mov.movie_id}"/>
						<c:param name="option" value="EDIT"/>
					</c:url>
					<c:url var="deletelink" value="admin">
						<c:param name="identifier" value="${mov.movie_id}"/>
						<c:param name="option" value="DELETE"/>
					</c:url>
	                <tr>
	                	<td> ${mov.movie_id}</td>
	                    <td> ${mov.title}</td>
						<td> ${mov.director}</td>
	                    <td> ${mov.cast_one}</td>
	                    <td> ${mov.cast_two}</td>
	                    <td> ${mov.cast_three}</td>
	                    <td> ${mov.genre}</td>
	                    <td><a href="${editlink}"><i class="bi bi-pencil-square"></i></a></td>
	                    <td><a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this movie?'))) return false"><i class="bi bi-trash"></i></a></td>
	                    <td> ${mov.trailer_link}</td>
	                    <td> ${mov.year_of_release}</td>
	                </tr>
	            </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/fixedheader/3.1.7/js/dataTables.fixedHeader.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.6/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.6/js/responsive.bootstrap.min.js  "></script>

    <script>
        $(document).ready(function() {
            var table = $('#movie_list').DataTable( {
                responsive: true
            } );
        
            new $.fn.dataTable.FixedHeader( table );
        } );
    </script>
</body>
</html>