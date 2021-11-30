package com.redfox.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeSQL(connection, statement, resultset);
		}
		return null;
	}
	
	public List getShowcase() {
		List db_rows = null;
		List new_release = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "Select image_id, image_binary From showcase_images;";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				db_rows = new ArrayList<String>();

            	db_rows.add(rs.getString(1));
            	db_rows.add(rs.getBlob(2));
            	new_release.add(db_rows);
			}
			return new_release;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSQL(con, stmt, rs);
		}
	}
	
	public void addMovie(Movie movie) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// get db connection
			connection = dataSource.getConnection();
			//sql insert statement has 11 inputs damn..💔😁
			String sql = "INSERT INTO `redfox`.`movies`(`movie_title`, `movie_description`, `movie_genre`, `movie_year_of_release`, `movie_director`, `movie_cast`, `movie_cast_two`, `movie_cast_three`, `movie_rating`, `movie_thumbnail`, `movie_trailer_link`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			statement = connection.prepareStatement(sql);
			
			//param values for the movie
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getDescription());
			statement.setString(3, movie.getGenre());
			statement.setInt(4, movie.getYear_of_release());
			statement.setString(5, movie.getDirector());
			statement.setString(6, movie.getCast_one());
			statement.setString(7, movie.getCast_two());
			statement.setString(8, movie.getCast_three());
			statement.setDouble(9, movie.getRate());
			statement.setBlob(10, movie.getThumbnail());
			statement.setString(11, movie.getTrailer_link());
			
			//add to db
			statement.execute();
		} finally {
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
