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

@WebServlet("/movieController")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Movie> movies = movieDAO.getMovies();
		List new_release = movieDAO.getShowcase();
		
		
		//request.setAttribute("Movie_List", movies);
		request.setAttribute("New_Release", new_release);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/movie_list.jsp");
		dispatcher.forward(request, response);
	}

}
