package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginValidationDao;
import com.util.MyHash;


public class LoginSuccessfulServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher(new RequestForwarder().routes(req)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		
		LoginValidationDao lvd = new LoginValidationDao();
		

		PrintWriter out = resp.getWriter();
		
		String inputPassword = req.getParameter("pword");
		String inputUsername = req.getParameter("users_id");
		
		
		MyHash mh = new MyHash(inputPassword, "SHA-256");
		
		String hashedPassword = "";
		try {
			hashedPassword = MyHash.generateHash(inputPassword, "SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String fullname = lvd.loginValidation(inputUsername, hashedPassword);
		
		int user_role_id = lvd.validateUserRoleID(inputUsername);
		
		
		
		
		
		if(fullname.length() <= 1)
		{
			String invalidloginpage = "/html_css_js/InvalidLogin.html";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(invalidloginpage);
			dispatcher.forward(req, resp);
		} 
		else
		{	
		
			if(user_role_id == 1)
			{
		
		out.println("<!doctype html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\"\n"
				+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
				+ "    <!-- Bootstrap CSS Files -->\n"
				+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"html_css_js/font-awesome-5.8.1.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"html_css_js/bootstrap.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"html_css_js/mdb.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"html_css_js/style.css\">\n"
				+ "<link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n"
				+ "<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n"
				+ "<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\n"
				+ "<link rel=\"stylesheet\" href=\"html_css_js/userprofile.css\" >"
				+ "    <title>WJLaw Dashboard</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "    <!-- Main Navbar -->\n"
				+ "    <nav class=\"navbar navbar-expand-sm navbar-dark bg-dark\">\n"
				+ "        <div class=\"container\">\n"
				+ "            <a href=\"index1.html\" class=\"navbar-brand text-warning\">\n"
				+ "               <i class=\"fa fa-snowflake\"></i>WJLaw LLC\n"
				+ "            </a>\n"
				+ "            <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#ui-navbar\">\n"
				+ "                <span class=\"navbar-toggler-icon\"></span>\n"
				+ "            </button>\n"
				+ "\n"
				+ "            <div class=\"collapse navbar-collapse\" id=\"ui-navbar\">\n"
				+ "                <ul class=\"navbar-nav ml-auto\">\n"
				+ "                    <li class=\"nav-item\">\n"
				+ "                        <a class=\"nav-link\" href=\"login.html\">\n"
				+ "                            <i class=\"fa fa-sign-out-alt text-muted\"></i> LogOut</a>\n"
				+ "                    </li>\n"
				+ "                </ul>\n"
				+ "            </div>\n"
				+ "        </div>\n"
				+ "    </nav>\n"
				+ "\n"
				+ "\n"
				+ "<div class=\"container\">\n"
				+ "    <div class=\"row profile\">\n"
				+ "		<div class=\"col-md-3\">\n"
				+ "			<div class=\"profile-sidebar\">\n"
				+ "				<!-- SIDEBAR USERPIC -->\n"
				+ "				<div class=\"profile-userpic\">\n"
				+ "					<img src=\"https://static.change.org/profile-img/default-user-profile.svg\" class=\"img-responsive\" alt=\"\">\n"
				+ "				</div>\n"
				+ "				<!-- END SIDEBAR USERPIC -->\n"
				+ "				<!-- SIDEBAR USER TITLE -->\n"
				+ "				<div class=\"profile-usertitle\">\n"
				+ "					<div class=\"profile-usertitle-name\">\n"
				+ fullname
				+ "					</div>\n"
				+ "					<div class=\"profile-usertitle-job\">\n"
				+ "						Attorney\n"
				+ "					</div>\n"
				+ "				</div>\n"
				+ "				<!-- END SIDEBAR USER TITLE -->\n"
				+ "				<!-- SIDEBAR BUTTONS -->\n"
				+ "				<div class=\"profile-userbuttons\">\n"
				+ "					<button type=\"button\" class=\"btn btn-success btn-sm\">Follow</button>\n"
				+ "					<button type=\"button\" class=\"btn btn-danger btn-sm\">Message</button>\n"
				+ "				</div>\n"
				+ "				<!-- END SIDEBAR BUTTONS -->\n"
				+ "				<!-- SIDEBAR MENU -->\n"
				+ "				<div class=\"profile-usermenu\">\n"
				+ "					<ul class=\"nav\">\n"
				+ "						<li class=\"active\">\n"
				+ "							<a href=\"#\">\n"
				+ "							<i class=\"glyphicon glyphicon-home\"></i>\n"
				+ "							WJLaw </a>\n"
				+ "						</li>\n"
				+ "						<li>\n"
				+ "							<a href=\"html_css_js/verifyusername.html\">\n"
				+ "							<i class=\"glyphicon glyphicon-user\"></i>\n"
				+ "							View Past Reimbursement Tickets </a>\n"
				+ "						</li>\n"
				+ "						<li>\n"
				+ "							<a href=\"html_css_js/bcf.html\">\n"
				+ "							<i class=\"glyphicon glyphicon-ok\"></i>\n"
				+ "							Add New Reimbursement Ticket </a>\n"
				+ "						</li>\n"
				+ "					</ul>\n"
				+ "				</div>\n"
				+ "				<!-- END MENU -->\n"
				+ "			</div>\n"
				+ "		</div>\n"
				+ "		<div class=\"col-md-9\">\n"
				+ "            <div class=\"profile-content\">\n"
				+ "			   Malesuada accumsan accumsan litora convallis tellus ligula mi eros primis. Aenean morbi sit sollicitudin aenean, orci quis dictum eleifend eros. Libero tortor, sagittis natoque! Nulla ac feugiat dictumst imperdiet risus. Habitant lacinia magna porta cum. Nisi mollis duis diam quisque quam vitae sollicitudin. Amet volutpat fringilla metus integer urna luctus ut volutpat gravida aenean. Nunc, volutpat diam torquent lacinia augue fames tempor parturient massa amet.\n"
				+ "<br>\n"
				+ "<br>\n"
				+ "Non metus tortor purus etiam augue facilisis ad massa, litora duis. Tortor consectetur, blandit ipsum felis sagittis. Inceptos justo sociosqu volutpat eu, himenaeos pharetra ac vivamus felis dapibus hendrerit. Mauris sodales volutpat eleifend parturient vivamus fringilla dictum morbi proin habitasse euismod. Quisque praesent interdum aliquet himenaeos sagittis amet adipiscing non tempus ultricies diam tempus! Lorem cum leo tellus aptent orci vel vivamus. Blandit pharetra blandit pellentesque ut. Felis dis torquent, nam vel aptent sociis. Elit nostra sit sed inceptos mauris magna rutrum quam porttitor magnis tristique proin? Duis facilisi enim nisi vulputate orci felis amet tristique enim nec netus quam. Elementum ipsum fermentum risus ac mi scelerisque ridiculus mus, metus aenean purus. Cum tristique cum aliquam bibendum aptent justo, orci cursus nisl netus. Platea ac tristique cum ut nibh egestas senectus! Platea mi faucibus velit adipiscing natoque aliquam montes leo. Potenti vulputate?\n"
				+ "<br>\n"
				+ "<br>\n"
				+ "Eleifend amet feugiat ac imperdiet pulvinar nisl. Dictum blandit elit ut facilisis vitae nulla, libero risus nec ut blandit cursus. Sollicitudin interdum, orci sit. Vel tempor ipsum tempor lectus fringilla tellus lobortis eget, eu ullamcorper orci. Fusce ornare ridiculus praesent primis ornare magna ullamcorper ornare mauris litora odio! Primis lobortis cum dictum cum accumsan tortor magna gravida; vestibulum eget! Elementum class netus neque ornare. Porta sodales pretium vulputate aenean pretium accumsan vehicula iaculis. Montes ac consectetur molestie nisl tellus eget. Venenatis class lacus sem litora netus maecenas facilisis cursus. Dictumst tempor nullam dignissim curabitur lacus? \n"
				+ "            </div>\n"
				+ "		</div>\n"
				+ "	</div>\n"
				+ "</div>"
				+ "\n"
				+ "    <!-- Main Footer -->\n"
				+ "    <footer class=\"p-3 bg-dark text-white text-center\">\n"
				+ "        <div class=\"container\">\n"
				+ "            <div class=\"row\">\n"
				+ "                <div class=\"col\">\n"
				+ "                    <h3>Copyright &copy; 2020 , WJLaw LLC</h3>\n"
				+ "                    <h6>All Rights Reserved</h6>\n"
				+ "                </div>\n"
				+ "            </div>\n"
				+ "        </div>\n"
				+ "    </footer>\n"
				+ "\n"
				+ "\n"
				+ "<!-- Bootstrap  JS Files -->\n"
				+ "<script src=\"bootstrap/js/jquery.js\"></script>\n"
				+ "<script src=\"bootstrap/js/popper.js\"></script>\n"
				+ "<script src=\"bootstrap/js/bootstrap.js\"></script>\n"
				+ "<script src=\"bootstrap/js/mdb.js\"></script>\n"
				+ "<script src=\"https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js\"></script>\n"
				+ "    <script>\n"
				+ "        CKEDITOR.replace( 'editor1' );\n"
				+ "    </script>\n"
				+ "</body>\n"
				+ "</html>");
			}
			
			if(user_role_id == 2)
			{
				
				out.println("<!doctype html>\n"
						+ "<html lang=\"en\">\n"
						+ "<head>\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\"\n"
						+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
						+ "    <!-- Bootstrap CSS Files -->\n"
						+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n"
						+ "    <link rel=\"stylesheet\" href=\"html_css_js/font-awesome-5.8.1.css\">\n"
						+ "    <link rel=\"stylesheet\" href=\"html_css_js/bootstrap.css\">\n"
						+ "    <link rel=\"stylesheet\" href=\"html_css_js/mdb.css\">\n"
						+ "    <link rel=\"stylesheet\" href=\"html_css_js/style.css\">\n"
						+ "<link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n"
						+ "<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n"
						+ "<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\n"
						+ "<link rel=\"stylesheet\" href=\"html_css_js/userprofile.css\" >"
						+ "    <title>WJLaw Dashboard</title>\n"
						+ "</head>\n"
						+ "<body>\n"
						+ "\n"
						+ "    <!-- Main Navbar -->\n"
						+ "    <nav class=\"navbar navbar-expand-sm navbar-dark bg-dark\">\n"
						+ "        <div class=\"container\">\n"
						+ "            <a href=\"index1.html\" class=\"navbar-brand text-warning\">\n"
						+ "               <i class=\"fa fa-snowflake\"></i>WJLaw LLC\n"
						+ "            </a>\n"
						+ "            <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#ui-navbar\">\n"
						+ "                <span class=\"navbar-toggler-icon\"></span>\n"
						+ "            </button>\n"
						+ "\n"
						+ "            <div class=\"collapse navbar-collapse\" id=\"ui-navbar\">\n"
						+ "                <ul class=\"navbar-nav ml-auto\">\n"
						+ "                    <li class=\"nav-item\">\n"
						+ "                        <a class=\"nav-link\" href=\"login.html\">\n"
						+ "                            <i class=\"fa fa-sign-out-alt text-muted\"></i> LogOut</a>\n"
						+ "                    </li>\n"
						+ "                </ul>\n"
						+ "            </div>\n"
						+ "        </div>\n"
						+ "    </nav>\n"
						+ "\n"
						+ "\n"
						+ "<div class=\"container\">\n"
						+ "    <div class=\"row profile\">\n"
						+ "		<div class=\"col-md-3\">\n"
						+ "			<div class=\"profile-sidebar\">\n"
						+ "				<!-- SIDEBAR USERPIC -->\n"
						+ "				<div class=\"profile-userpic\">\n"
						+ "					<img src=\"https://static.change.org/profile-img/default-user-profile.svg\" class=\"img-responsive\" alt=\"\">\n"
						+ "				</div>\n"
						+ "				<!-- END SIDEBAR USERPIC -->\n"
						+ "				<!-- SIDEBAR USER TITLE -->\n"
						+ "				<div class=\"profile-usertitle\">\n"
						+ "					<div class=\"profile-usertitle-name\">\n"
						+ fullname
						+ "					</div>\n"
						+ "					<div class=\"profile-usertitle-job\">\n"
						+ "						Finance Manager/Partner\n"
						+ "					</div>\n"
						+ "				</div>\n"
						+ "				<!-- END SIDEBAR USER TITLE -->\n"
						+ "				<!-- SIDEBAR BUTTONS -->\n"
						+ "				<div class=\"profile-userbuttons\">\n"
						+ "					<button type=\"button\" class=\"btn btn-success btn-sm\">Follow</button>\n"
						+ "					<button type=\"button\" class=\"btn btn-danger btn-sm\">Message</button>\n"
						+ "				</div>\n"
						+ "				<!-- END SIDEBAR BUTTONS -->\n"
						+ "				<!-- SIDEBAR MENU -->\n"
						+ "				<div class=\"profile-usermenu\">\n"
						+ "					<ul class=\"nav\">\n"
						+ "						<li class=\"active\">\n"
						+ "							<a href=\"#\">\n"
						+ "							<i class=\"glyphicon glyphicon-home\"></i>\n"
						+ "							WJLaw </a>\n"
						+ "						</li>\n"
						+ "                      <form action=\"http://localhost:8080/ExpenseReimbursementApplication/ViewPendingReimbServlet\" method=\"POST\" "
						+ "						<li>\n"
						+ " <div> <button class=\"form__btn\" type=\"submit\">View Pending Reimbursement Tickets</button>  </div>"	
						+ "							<i class=\"glyphicon glyphicon-ok\"></i>\n"
						+ "						</li>\n"
						+ "                      </form>"
						+ "						<li>\n"
						+ "							<a href=\"html_css_js/approvereimb.html\">\n"
						+ "							<i class=\"glyphicon glyphicon-ok\"></i>\n"
						+ "							Approve Reimbursement Ticket </a>\n"
						+ "						</li>\n"
						+                       "<li>\n"
						+ "							<a href=\"html_css_js/rejectreimb.html\">\n"
						+ "							<i class=\"glyphicon glyphicon-ok\"></i>\n"
						+ "							Reject Reimbursement Ticket </a>\n"
						+ "						</li>\n"
						+ "					</ul>\n"
						+ "				</div>\n"
						+ "				<!-- END MENU -->\n"
						+ "			</div>\n"
						+ "		</div>\n"
						+ "		<div class=\"col-md-9\">\n"
						+ "            <div class=\"profile-content\">\n"
						+ "			   Malesuada accumsan accumsan litora convallis tellus ligula mi eros primis. Aenean morbi sit sollicitudin aenean, orci quis dictum eleifend eros. Libero tortor, sagittis natoque! Nulla ac feugiat dictumst imperdiet risus. Habitant lacinia magna porta cum. Nisi mollis duis diam quisque quam vitae sollicitudin. Amet volutpat fringilla metus integer urna luctus ut volutpat gravida aenean. Nunc, volutpat diam torquent lacinia augue fames tempor parturient massa amet.\n"
						+ "<br>\n"
						+ "<br>\n"
						+ "Non metus tortor purus etiam augue facilisis ad massa, litora duis. Tortor consectetur, blandit ipsum felis sagittis. Inceptos justo sociosqu volutpat eu, himenaeos pharetra ac vivamus felis dapibus hendrerit. Mauris sodales volutpat eleifend parturient vivamus fringilla dictum morbi proin habitasse euismod. Quisque praesent interdum aliquet himenaeos sagittis amet adipiscing non tempus ultricies diam tempus! Lorem cum leo tellus aptent orci vel vivamus. Blandit pharetra blandit pellentesque ut. Felis dis torquent, nam vel aptent sociis. Elit nostra sit sed inceptos mauris magna rutrum quam porttitor magnis tristique proin? Duis facilisi enim nisi vulputate orci felis amet tristique enim nec netus quam. Elementum ipsum fermentum risus ac mi scelerisque ridiculus mus, metus aenean purus. Cum tristique cum aliquam bibendum aptent justo, orci cursus nisl netus. Platea ac tristique cum ut nibh egestas senectus! Platea mi faucibus velit adipiscing natoque aliquam montes leo. Potenti vulputate?\n"
						+ "<br>\n"
						+ "<br>\n"
						+ "Eleifend amet feugiat ac imperdiet pulvinar nisl. Dictum blandit elit ut facilisis vitae nulla, libero risus nec ut blandit cursus. Sollicitudin interdum, orci sit. Vel tempor ipsum tempor lectus fringilla tellus lobortis eget, eu ullamcorper orci. Fusce ornare ridiculus praesent primis ornare magna ullamcorper ornare mauris litora odio! Primis lobortis cum dictum cum accumsan tortor magna gravida; vestibulum eget! Elementum class netus neque ornare. Porta sodales pretium vulputate aenean pretium accumsan vehicula iaculis. Montes ac consectetur molestie nisl tellus eget. Venenatis class lacus sem litora netus maecenas facilisis cursus. Dictumst tempor nullam dignissim curabitur lacus? \n"
						+ "            </div>\n"
						+ "		</div>\n"
						+ "	</div>\n"
						+ "</div>"
						+ "\n"
						+ "    <!-- Main Footer -->\n"
						+ "    <footer class=\"p-3 bg-dark text-white text-center\">\n"
						+ "        <div class=\"container\">\n"
						+ "            <div class=\"row\">\n"
						+ "                <div class=\"col\">\n"
						+ "                    <h3>Copyright &copy; 2020 , WJLaw LLC</h3>\n"
						+ "                    <h6>All Rights Reserved</h6>\n"
						+ "                </div>\n"
						+ "            </div>\n"
						+ "        </div>\n"
						+ "    </footer>\n"
						+ "\n"
						+ "\n"
						+ "<!-- Bootstrap  JS Files -->\n"
						+ "<script src=\"bootstrap/js/jquery.js\"></script>\n"
						+ "<script src=\"bootstrap/js/popper.js\"></script>\n"
						+ "<script src=\"bootstrap/js/bootstrap.js\"></script>\n"
						+ "<script src=\"bootstrap/js/mdb.js\"></script>\n"
						+ "<script src=\"https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js\"></script>\n"
						+ "    <script>\n"
						+ "        CKEDITOR.replace( 'editor1' );\n"
						+ "    </script>\n"
						+ "</body>\n"
						+ "</html>");
				
			}
		
		}
		
		// req.getRequestDispatcher(new RequestForwarder().routes(req)).forward(req, resp);
	}
	
}
