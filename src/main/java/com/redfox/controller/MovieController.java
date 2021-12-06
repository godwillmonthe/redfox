package com.redfox.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.redfox.model.BEAN.Movie;
import com.redfox.model.DAO.MovieDAO;

@WebServlet("/movieController")
@MultipartConfig(maxFileSize = 1617721690)
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDAO movieDAO;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
    
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		movieDAO = new MovieDAO(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chosenOption = request.getParameter("option");
		
		if(chosenOption == null)
			listHomepageMovies(request,response);
		else if(chosenOption.equals("ADD"))
			addMovie(request, response);
		else if(chosenOption.equals("LOAD"))
			listMovies(request,response);
		else if(chosenOption.equals("DISPLAY"))
			movieDetails(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movie_title = request.getParameter("movie_title");
		String movie_desc = request.getParameter("movie_desc");
		String movie_director = request.getParameter("movie_director");
		String movie_cast_one = request.getParameter("movie_cast_one");
		String movie_cast_two = request.getParameter("movie_cast_two");
		String movie_cast_three = request.getParameter("movie_cast_three");
		String movie_genre = request.getParameter("movie_genre");
		String movie_trailer_link = request.getParameter("movie_trailer_link");
		Part movie_thumbnail = request.getPart("movie_thumbnail");
		String movie_year_of_release = request.getParameter("movie_year_of_release");
		
		Movie movie = new Movie(movie_title, movie_desc, movie_genre, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_trailer_link, movie_year_of_release, movie_thumbnail);
		try {
			int rs = movieDAO.addMovie(movie);
			if(rs > 0) {
				System.out.println(movie.toString());
				System.out.println("upload successful");
				request.setAttribute("message", "Upload Successful!");
				this.getServletContext().getRequestDispatcher("/add_movie.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Upload Unsuccessful!, An Error has Occured");
				this.getServletContext().getRequestDispatcher("/add_movie.jsp").forward(request, response);
				System.out.println("Oa palelwa MR.");
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Movie> movies = movieDAO.getMovies();
		
		request.setAttribute("Movie_List", movies);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/movie_list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void listHomepageMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer> new_release = movieDAO.getShowcase();
		List<Movie> movies = movieDAO.getHomeMovies();
		
		request.setAttribute("New_Release", new_release);
		request.setAttribute("Home_Movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void movieDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("identifier"));
		Movie movie = movieDAO.getAMovie(id);
		
		if (movie == null) {
			response.sendRedirect("error.jsp");
		} else {
			request.setAttribute("theMovie", movie);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/movie_details.jsp");
			dispatcher.forward(request, response);
		}
	}
	
}
