package com.redfox.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.redfox.model.BEAN.Subscriber;
import com.redfox.model.DAO.SubscriberDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubscriberDAO subDAO;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
       
    public Login() {
        super();
    }
    
    public void init() throws ServletException {
		subDAO = new SubscriberDAO(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		
		Subscriber user = new Subscriber();
		user = subDAO.login(email, pass);
		if (user != null) {
//			request.setAttribute("user", user);
			session.setAttribute("active_subscriber", user);
			this.getServletContext().getRequestDispatcher("/movieController").forward(request, response);
			
//			response.sendRedirect("home.jsp?login=success");
		} else {
			request.setAttribute("error", "invalid user credentials!!");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
