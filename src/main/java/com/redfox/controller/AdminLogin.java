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

import com.redfox.model.BEAN.Employee;
import com.redfox.model.DAO.EmployeeDAO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO empDAO;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
       
    public AdminLogin() {
        super();
    }
    
    public void init() throws ServletException {
    	empDAO = new EmployeeDAO(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		
		Employee emp = new Employee();
		emp = empDAO.login(email, pass);
		if (emp != null) {
//			request.setAttribute("user", user);
			session.setAttribute("active_admin", emp);
			this.getServletContext().getRequestDispatcher("/admin").forward(request, response);
			
//			response.sendRedirect("home.jsp?login=success");
		} else {
			request.setAttribute("error", "invalid user credentials!!");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
