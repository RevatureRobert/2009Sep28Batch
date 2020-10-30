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
 * Servlet implementation class ViewPendingReimbServlet
 */
public class ViewPendingReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static Logger logger = Logger.getLogger(ViewPendingReimbServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPendingReimbServlet() {
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("The finance manager is viewing pending reimbursement tickets");
		EmployeeDao ed = new EmployeeDao();
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
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
				+ "</head>\n");
		out.print("<h1>Pending Reimbursements</h1>");
		out.print("<table class=\"content-table\"><thead><tr><th>reimb_id</th><th>Amount</th><th>Time Submitted</th><th>Description</th><th>Receipt</th><th>Author</th><th>Status</th><th>Type</th></tr></thead>");
		String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id from \"Project1\".reimbursement where reimb_status_id  = 1;";
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ResultSet rs = ps.executeQuery();
			
				out.print("<tbody>");
			
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
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getLong(5));
				out.print("</td>");
				out.print("<td>");
				int userid = rs.getInt(6);
				
				String fullname = ed.findfullNamebyUserID(userid);
				
				out.print(fullname);
				out.print("</td>");
				out.print("<td>");
				int status = rs.getInt(7);
				if(status == 1)
				{
					out.print("Pending");
				}
				out.print("</td>");
				out.print("<td>");
				int type = rs.getInt(8);
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
				
			}
		}
		catch(SQLException e)
		{
			
			System.out.println("Exception bro");
			e.printStackTrace();
			
		}
		out.print("</tbody>");
		out.print("</table>");
		
		out.print("<input  class = \"btn\" type=\"button\"style = \"background-color:limegreen\" value=\"Go back to Profile Page\" onclick=\"history.go(-1)\">");
	}

}
