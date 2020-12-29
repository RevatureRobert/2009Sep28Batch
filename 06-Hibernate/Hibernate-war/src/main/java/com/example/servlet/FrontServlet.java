package com.example.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Oven;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet(name="data", urlPatterns = {"*.json"})
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FrontServlet() {
        // TODO Auto-generated constructor stub
    }

	/**6
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Oven o = new Oven(0, "stainless steel", 350, new HashSet<>());
		
		/*
		Turkey t1 = new Turkey(0, "goongis", 50, true, o);
		Turkey t2 = new Turkey(0, "dongus", 25, true, o);
		Turkey t3 = new Turkey(0, "ra", 100, false, o);
		
		o.getTurkeys().add(t1);
		o.getTurkeys().add(t2);
		o.getTurkeys().add(t3);
		
		OvenDao od = new OvenDao();
		
		od.save(o);
		
		o = od.findById(1);
		*/
		
		
		response.getWriter().println(o);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
