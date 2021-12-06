package com.redfox.model.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@WebServlet("/uploadImage")
@MultipartConfig(maxFileSize = 1617721690)
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/RedFox")
	private DataSource datasource;
       
    public UploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		Connection con = null;
		Part part = request.getPart("image");
		int id = Integer.parseInt(request.getParameter("id"));
		 
		if(part != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = datasource.getConnection();
			    
			    PreparedStatement ps = con.prepareStatement("update movies set movie_thumbnail = ? where movie_id = ?;");
			    InputStream is = part.getInputStream();
			    ps.setBlob(1, is);
			    ps.setInt(2, id);
			    result = ps.executeUpdate();
			    } catch(Exception e) {
				e.printStackTrace();
					} finally {
						if(con != null) {
							try {
								con.close();
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
			}
			if(result > 0){
				response.sendRedirect("result.jsp?message=Image+Uploaded");
		    } else {
		    	response.sendRedirect("result.jsp?message=Some+Error+Occurred");
		    }	 
		}
}

