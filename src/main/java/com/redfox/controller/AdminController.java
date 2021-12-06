package com.redfox.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.redfox.model.BEAN.Movie;
import com.redfox.model.DAO.MovieDAO;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDAO movieDAO;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
    
    public AdminController() {
        super();
    }

    public void init() throws ServletException {
		movieDAO = new MovieDAO(datasource);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminOption = request.getParameter("option");
		
		if(adminOption == null)
			adminHome(request,response);
		else if(adminOption.equals("LIST"))
			listMovies(request,response);
		else if(adminOption.equals("EDIT"))
			editMovie(request, response);
		else if(adminOption.equals("UPDATE"))
			try {
				updateMovie(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(adminOption.equals("DELETE"))
			try {
				deleteMovie(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void adminHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");
		dispatcher.forward(request, response);
	}

	private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Movie> movies = movieDAO.getMovies();
		
		request.setAttribute("admin_movie_List", movies);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_movie_list.jsp");
		dispatcher.forward(request, response);
	}

	private void editMovie(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("identifier"));
		Movie movie = movieDAO.getAMovie(id);
		
		if (movie == null) {
			response.sendRedirect("error.jsp");
		} else {
			request.setAttribute("editMovie", movie);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_movie_details.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	private void updateMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String movie_title = request.getParameter("movie_title");
		String movie_desc = request.getParameter("movie_desc");
		String movie_director = request.getParameter("movie_director");
		String movie_cast_one = request.getParameter("movie_cast_one");
		String movie_cast_two = request.getParameter("movie_cast_two");
		String movie_cast_three = request.getParameter("movie_cast_three");
		String movie_genre = request.getParameter("movie_genre");
		String movie_trailer_link = request.getParameter("movie_trailer_link");
		String movie_year_of_release = request.getParameter("movie_year_of_release");
		
		Movie updateMovie = new Movie(movie_title, movie_desc, movie_genre, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_trailer_link, movie_year_of_release);
		
		// perform update on database
		int result = movieDAO.updateMovie(updateMovie);
		
		if(result > 0) {
			request.setAttribute("message", "Update Successful!");
			this.getServletContext().getRequestDispatcher("/admin_movie_list.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Update Unsuccessful!, An Error has Occured");
			this.getServletContext().getRequestDispatcher("/edit_movie_details.jsp").forward(request, response);
			System.out.println("Oa palelwa MR.");
		}
		
		// send them back to the "list movies" page
		listMovies(request, response);
		
	}

	
	private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student id from form data
		int movie_id = Integer.parseInt(request.getParameter("identifier"));
		
		// delete student from database
		movieDAO.deleteMovie(movie_id);
		
		// send them back to "list students" page
		listMovies(request, response);
	}

}
