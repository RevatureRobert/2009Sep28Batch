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

import com.util.ConnectionUtil;

/**
 * Servlet implementation class ViewPendingReimbServlet
 */
public class ViewPendingReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>Pending Reimbursements</h1>");
		out.print("<table border = '1'><tr><th>reimb_id</th><th>Amount</th><th>Time Submitted</th><th>Description</th><th>Receipt</th><th>AuthorID</th><th>StatusID</th><th>TypeID</th></tr>");
		String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id from \"Project1\".reimbursement where reimb_status_id  = 1;";
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
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
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getLong(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(6));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(7));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(8));
				out.print("</td>");
				
			}
		}
		catch(SQLException e)
		{
			
			System.out.println("Exception bro");
			e.printStackTrace();
			
		}
		
		out.print("</table>");
	}

}
