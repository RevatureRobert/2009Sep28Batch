package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UpdatedPasswordDao;
import com.util.MyHash;

/**
 * Servlet implementation class UpdatedPasswordServlet
 */
public class UpdatedPasswordServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		
		UpdatedPasswordDao upd = new UpdatedPasswordDao();
		
		String username = req.getParameter("users_id");
		String npw = req.getParameter("newpword");
		
		MyHash mh = new MyHash(npw, "SHA-256");
		
		String hashedPassword = "";
		try {
			hashedPassword = MyHash.generateHash(req.getParameter("newpword"), "SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		upd.updatePassword(username, hashedPassword);
		
		out.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Updated Password Success!</title>\n"
				+ "</head>\n"
				+ "<body>\n"
			+ "<p> Your user id is " + req.getParameter("users_id")	+ " and your new password is " + req.getParameter("newpword") + "</p>\n Your new password in hash form is " + hashedPassword +  "</body>\n"
				+ "</html>");
		
	}

}
