package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.EmployeeDao;
import com.util.ConnectionUtil;

/**
 * Servlet implementation class ViewPastReimbServlet
 */

public class ViewPastReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static Logger logger = Logger.getLogger(ViewPastReimbServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPastReimbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	/**
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		logger.info("The user is viewing their past reimbursements");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("usrname");
		
		EmployeeDao ed = new EmployeeDao();
		
		int userID = ed.findUserIDByUserName(username);
		
		out.print("<!DOCTYPE html>\n"
				+ "\n"
				+ "<html>\n"
				+ "\n"
				+ "<head>\n"
				+ "\n"
				+ " <title>Table layout</title>\n"
				+ "\n"
				+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"html_css_js/tablestyler2.css\">\n"
				+ "\n"
				+ "	<link rel=\"stylesheet\" type=\"text/js\" href= \"html_css_js/bcf.js\">\n"
				+ "	\n"
				+ "<script>\n"
				+ "function goBack() {\n"
				+ "  window.history.back();\n"
				+ "}\n"
				+ "$(document).on('keydown', 'input[pattern]', function(e){\n"
				+ "	  var input = $(this);\n"
				+ "	  var oldVal = input.val();\n"
				+ "	  var regex = new RegExp(input.attr('pattern'), 'g');\n"
				+ "\n"
				+ "	  setTimeout(function(){\n"
				+ "	    var newVal = input.val();\n"
				+ "	    if(!regex.test(newVal)){\n"
				+ "	      input.val(oldVal); \n"
				+ "	    }\n"
				+ "	  }, 0);\n"
				+ "	});\n"
				+ "parseFloat($(this).val()).toFixed(2)\n"
				+ "</script>"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				+ "\n"
				+ "\n"
				+ "  <div class=\"filter\">\n"
				+ "\n"
				+ " </div>");
		
		out.print("<table class=\"content-table\"><thead><tr><th>reimb_id</th><th>Amount</th><th>Time Submitted</th><th>Time Resolved</th><th>Description</th><th>Receipt</th><th>AuthorID</th><th>Resolver</th><th>Status</th><th>Type</th></tr></thead>");
		
		
	String sql = "select * from \"Project1\".reimbursement where reimb_author = ?";
		

		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getFloat(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getTimestamp(3));
				out.print("</td>");
				out.print("<td>");
				
				if(rs.getTimestamp(4) == null)
				{
					out.print("Unresolved");
				}
				else
				{
				out.print(rs.getTimestamp(4));
				}
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getLong(6));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(7));
				out.print("</td>");
				out.print("<td>");
				int fm_id = rs.getInt(8);
				if(fm_id == 1)
				{
					out.print("Thomas Wilkins");
				}	
				else if(fm_id == 2)
				{
					out.print("Kenny Jones");
				}
				else
				{
					out.print("Unresolved");
				}
				out.print("</td>");
				out.print("<td>");
				int statusid = rs.getInt(9);
				if(statusid == 1)
				{
					out.print("Pending");
				}
				if(statusid == 2)
				{
					out.print("Approved");
				}
				if(statusid == 3)
				{
					out.print("Rejected");
				}
				out.print("</td>");
				out.print("<td>");
				int type = rs.getInt(10);
				if(type == 1)
				{
					out.print("Lodging");
				}
				if(type == 2)
				{
					out.print("Travel");
				}
				if(type == 3)
				{
					out.print("Food");
				}
				if(type == 4)
				{
					out.print("Other");
				}
				out.print("</td>");
				out.print("</tr>");
				
			}
		}
		catch(SQLException e)
		{
			
			System.out.println("Exception bro");
			e.printStackTrace();
			
		}
		
		out.print("</table>");

		
		 out.print("<input  class = \"btn\" style = \"background-color:limegreen\" type=\"button\" value=\"Go back to Profile Page\" onclick=\"history.go(-2)\">");
		
		
	}
	
}


