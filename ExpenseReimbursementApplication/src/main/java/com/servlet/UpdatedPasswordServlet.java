package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
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
		
		/*
			String backtologinpage = "/html_css_js/loginpage.html";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backtologinpage);
			dispatcher.forward(req, resp);
		*/
		
		
		out.print("<!doctype html>\n"
				+ "<html lang=\"en\">\n"
				+ "\n"
				+ "<head>\n"
				+ "    <!-- Required meta tags -->\n"
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
				+ "\n"
				+ "    <!-- Bootstrap CSS -->\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n"
				+ "        integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n"
				+ "    \n"
				+ "    <!-- Custom CSS -->\n"
				+ "    <link rel=\"stylesheet\" href=\"html_css_js/style.css\">\n"
				+ "\n"
				+ "    <title>Wilkins and Jones Law Firm</title>\n"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				+ "    <div class=\"container\">\n"
				+ "        <header class=\"head my-3\">\n"
				+ "            <nav class=\"navbar navbar-expand-lg navbar-light head__custom-nav\">\n"
				+ "                <a class=\"navbar-brand d-flex align-items-center\" href=\"#\">\n"
				+ "                    <img src=\"html_css_js/logo.png\" alt=\"website logo\">\n"
				+ "                    <span>WJLaw</span>\n"
				+ "                </a>\n"
				+ "                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\">\n"
				+ "                    <span><img src=\"html_css_js/menu.png\" alt=\"\"></span>\n"
				+ "                </button>\n"
				+ "                <div class=\"collapse navbar-collapse justify-content-end\" id=\"navbarNav\">\n"
				+ "                    <ul class=\"navbar-nav\">\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" href=\"#\">Home</a>\n"
				+ "                        </li>\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" href=\"#\">About us</a>\n"
				+ "                        </li>\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link\" href=\"html_css_js/loginpage.html\">Login</a>\n"
				+ "                        </li>\n"
				+ "                        <li class=\"nav-item\">\n"
				+ "                            <a class=\"nav-link text-primary\" href=\"#\">Contact us</a>\n"
				+ "                        </li>\n"
				+ "                    </ul>\n"
				+ "                </div>\n"
				+ "            </nav>\n"
				+ "        </header>\n"
				+ "    </div>\n"
				+ "    <div class=\"container\">\n"
				+ "        <div class=\"row custom-section d-flex align-items-center\">\n"
				+ "            <div class=\"col-12 col-lg-4\">\n"
				+ "                <h2>Wilkins and Jones</h2>\n"
				+ "                <h3>Law Firm</h3>\n"
				+ "                <p>Best Corporate Law Firm in the USA!</p>\n"
				+ "                <a href=\"#\">Learn more</a>\n"
				+ "            </div>\n"
				+ "            <!--  \n"
				+ "            <div class=\"col-12 col-lg-8\">\n"
				+ "                <img src=\"pexels-quintin-gellar-313782.jpg\" alt=\"Team process banner\">\n"
				+ "            </div> -->\n"
				+ "        </div>\n"
				+ "    </div>\n"
				+ "\n"
				+ "    <!-- Optional JavaScript -->\n"
				+ "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n"
				+ "    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"\n"
				+ "        integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\">\n"
				+ "    </script>\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n"
				+ "        integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\">\n"
				+ "    </script>\n"
				+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n"
				+ "        integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\">\n"
				+ "    </script>\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>");
	}

}
