package com.redfox.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.redfox.model.BEAN.Subscriber;
import com.redfox.model.DAO.SubscriberDAO;

/**
 * Servlet implementation class AddNewSubscriber
 */
@WebServlet("/adduser")
public class AddNewSubscriber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubscriberDAO subDAO;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
       
    public AddNewSubscriber() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String c_password = request.getParameter("confirm_password");
		
		if(password.equals(c_password)) {
			Subscriber user = new Subscriber(firstName, lastName, emailAddress, password);
			SubscriberDAO usrDAO = new SubscriberDAO(datasource);
			
			int result = usrDAO.addSubscriber(user);
			
			if(result > 0) {
				response.sendRedirect("index.jsp?registration=success");
			} else {
				System.out.println("Something went wrong!!");
			}
		} else {
			System.out.println("passwords do not match!!");
		}
		
	}

}
