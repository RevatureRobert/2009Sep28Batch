package com.bank.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.DAO.EmployeeDAOim;
import com.bank.DAO.UserDAOim;
import com.bank.model.Role;
import com.bank.model.User;

public class RegisterController {
 static public void  RegisterUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

int role_id=3;
 String first_name=request.getParameter("first_name") ; 
 String  last_name=request.getParameter("last_name");
 String email_address=request.getParameter("email_address"); 
 String username=request.getParameter("username");
 String  password=request.getParameter("password");
 String  employee=request.getParameter("employee");
  
 UserDAOim ud= new UserDAOim();

int ret_email =ud.findUserbyEmail(email_address);
int ret_username=ud.findUserbyUsername(username);

System.out.println("is email for "+ret_email);
System.out.println("is username for: "+ ret_username);
  
if (ret_email>0 || ret_username>0) {
	RequestDispatcher   red=request.getRequestDispatcher("/registerfailed.html");
	red.forward(request, response);
}else
{

EmployeeDAOim emDAO= new EmployeeDAOim();

 
 int ret=emDAO.getEmployeebyUsernamePaassword(username, password);
 boolean b=emDAO.isEmployeeAdmin(username, password);

System.out.println(ret);
System.out.println(employee);

if ((employee  != null  ) && (ret)>0 && b==true) {
      
	role_id=1;
}else if ((employee  != null  ) && (ret)>0){
   role_id=3;
 }else {
	   role_id=2;
   }
System.out.println(employee);
System.out.println("return from employee:" + ret+" "+b);

User u=new User(username, password, first_name, last_name, email_address,new Role(role_id)); 
ud.RegisterUser(u);
 response.sendRedirect("http://localhost:8080/rocp-project/login.html");

}
}
 }

 
 

