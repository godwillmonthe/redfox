package com.redfox.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.redfox.model.BEAN.Subscriber;

public class SubscriberDAO {
	private PreparedStatement stmt = null;
	private Connection conn;
	private DataSource dataSource;
	
	public SubscriberDAO() {
		
	}
	
	public SubscriberDAO(DataSource datasource) {
		dataSource = datasource;
	}
	
	public int addSubscriber(Subscriber user) {
		
		String first = user.getFirstname();
		String last = user.getSurname();
		String email = user.getEmailAddress();
		String pass = user.getPassword();
		String query = "INSERT INTO subscriber(firstname, surname, email, password) VALUES(?,?,?,?);";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(query);
			stmt = conn.prepareStatement(query);
			stmt.setString(1, first);
			stmt.setString(2, last);
			stmt.setString(3, email);
			stmt.setString(4, pass);
			int result = stmt.executeUpdate();
			
			
			if(result > 0) {
				System.out.println("Successfully inserted data to database.");
				return result;
			} else {
				System.out.println("Failed to insert data!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSQL(conn, stmt, null);
		}
		return 0;
	}
	
	public Subscriber login(String email, String password) {
		String query = "SELECT * FROM subscriber WHERE email = ? AND password = ?;";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Subscriber user = new Subscriber();
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("surname");
				user.setFirstname(firstname);
				user.setSurname(lastname);
				user.setEmailAddress(email);
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSQL(conn, stmt, null);
		}
		return null;
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
