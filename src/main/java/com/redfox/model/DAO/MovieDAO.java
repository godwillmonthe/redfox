package com.redfox.model.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.redfox.model.BEAN.Movie;

public class MovieDAO {
	private DataSource dataSource;
	
	public MovieDAO(DataSource datasource) {
		dataSource = datasource;
	}
	
	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String sql = "Select * From movies;";
			resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				//loop through database and add movies to list
				int movie_id = resultset.getInt("movie_id");
				String movie_title = resultset.getString("movie_title");
				String movie_desc = resultset.getString("movie_description");
				String movie_director = resultset.getString("movie_director");
				String movie_cast_one = resultset.getString("movie_cast_one");
				String movie_cast_two = resultset.getString("movie_cast_two");
				String movie_cast_three = resultset.getString("movie_cast_three");
				String movie_genre = resultset.getString("movie_genre");
				String movie_trailer_link = resultset.getString("movie_trailer_link");
				String movie_year_of_release = resultset.getString("movie_year_of_release");
				
				Movie movie = new Movie(movie_title, movie_desc, movie_genre, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_trailer_link, movie_year_of_release);
				movie.setMovie_id(movie_id);
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeSQL(connection, statement, resultset);
		}
		return null;
	}
	
	public List<Movie> getHomeMovies() {
		List<Movie> movies = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String sql = "Select * From movies;";
			resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				//loop through database and add movies to list
				int movie_id = resultset.getInt("movie_id");
				String movie_title = resultset.getString("movie_title");
				String genre = resultset.getString("movie_genre");
				String year = resultset.getString("movie_year_of_release");
				
				Movie movie = new Movie();
				movie.setTitle(movie_title);
				movie.setGenre(genre);
				movie.setMovie_id(movie_id);
				movie.setYear_of_release(year);
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeSQL(connection, statement, resultset);
		}
		return null;
	}
	
	public List<Integer> getShowcase() {
		List<Integer> new_release = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "Select image_id From showcase_images;";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
            	new_release.add(rs.getInt(1));
			}
			return new_release;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSQL(con, stmt, rs);
		}
	}
	
	public int addMovie(Movie movie) throws SQLException, IOException {
		Connection connection = null;
		PreparedStatement statement = null;
		Part thumbnail = movie.getThumbnail();
		String sql = null;
		InputStream thumbnail_is = null;
		
		if(thumbnail == null) {
			sql = "INSERT INTO movies (movie_title, movie_description, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_genre, movie_trailer_link, movie_year_of_release) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

		} else {
			sql = "INSERT INTO movies (movie_title, movie_description, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_genre, movie_trailer_link, movie_year_of_release, movie_thumbnail) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			thumbnail_is = thumbnail.getInputStream();
		}
		
		try {
			// get db connection
			connection = dataSource.getConnection();
			//sql insert statement has 11 inputs damn..💔😁
			statement = connection.prepareStatement(sql);
			
			
			//param values for the movie
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getDescription());
			statement.setString(3, movie.getDirector());
			statement.setString(4, movie.getCast_one());
			statement.setString(5, movie.getCast_two());
			statement.setString(6, movie.getCast_three());
			statement.setString(7, movie.getGenre());
			statement.setString(8, movie.getTrailer_link());
			statement.setString(9, movie.getYear_of_release());
			if(thumbnail != null)
				statement.setBlob(10, thumbnail_is);
			
			//add to db
			int result = statement.executeUpdate();
			return result;
		} finally {
			closeSQL(connection, statement, null);
		}
		
		
	}
	
	public Movie getAMovie(int id){
		
		Movie movie = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String sql = "Select * From movies where movie_id = ?";
			
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			resultset = statement.executeQuery();
			
			
			if(resultset.next()) {
				
				int movie_id = resultset.getInt("movie_id");
				String movie_title = resultset.getString("movie_title");
				String movie_desc = resultset.getString("movie_description");
				String movie_director = resultset.getString("movie_director");
				String movie_cast_one = resultset.getString("movie_cast_one");
				String movie_cast_two = resultset.getString("movie_cast_two");
				String movie_cast_three = resultset.getString("movie_cast_three");
				String movie_genre = resultset.getString("movie_genre");
				String movie_trailer_link = resultset.getString("movie_trailer_link");
				String movie_year_of_release = resultset.getString("movie_year_of_release");
				
				movie = new Movie(movie_title, movie_desc, movie_genre, movie_director, movie_cast_one, movie_cast_two, movie_cast_three, movie_trailer_link, movie_year_of_release);
				movie.setMovie_id(movie_id);
			}
			
			return movie;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;	
		}
		
		finally {
			closeSQL(connection, statement, resultset);	
		}
		
		
		
	}
	
	public int updateMovie(Movie updateMovie) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// get db connection
			connection = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "UPDATE movies SET movie_title = ?, movie_description = ?, movie_director = ?, movie_cast_one = ?, movie_cast_two = ?, movie_cast_three = ?, movie_genre = ?, movie_trailer_link = ?, movie_year_of_release = ? WHERE movie_id = ?;";
			
			// prepare statement
			statement = connection.prepareStatement(sql);
			
			// set params
			statement.setString(1, updateMovie.getTitle());
			statement.setString(2, updateMovie.getDescription());
			statement.setString(3, updateMovie.getDirector());
			statement.setString(4, updateMovie.getCast_one());
			statement.setString(5, updateMovie.getCast_two());
			statement.setString(6, updateMovie.getCast_three());
			statement.setString(7, updateMovie.getGenre());
			statement.setString(8, updateMovie.getTrailer_link());
			statement.setString(9, updateMovie.getYear_of_release());
			statement.setInt(10, updateMovie.getMovie_id());
			
			// execute SQL statement
			int result = statement.executeUpdate();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		finally {
			// clean up JDBC objects
			closeSQL(connection, statement, null);
		}
	}
	
	public void deleteMovie(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			// get connection to database
			connection = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from movies where movie_id=?";
			
			// prepare statement
			statement = connection.prepareStatement(sql);
			
			// set params
			statement.setInt(1, id);
			
			// execute sql statement
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// clean up JDBC code
			closeSQL(connection, statement, null);
		}
		
	}

	private void closeSQL(Connection connection, Statement statement, ResultSet resultset) {
		// TODO Auto-generated method stub
		try {
			if(resultset != null)
				resultset.close();
			
			if(statement != null)
				statement.close();
			
			if(connection != null) // frees the connection for use in connection pulling
				connection.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
