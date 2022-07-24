package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.Configuration;

import com.db.App;
import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.printf(username,password);
		User u = new User();
		HttpSession session = request.getSession();
		
		App app = new App();
		
//		session.setAttribute("userObj",u);
		
		if(username.equals("jayendra@") && password.equals("1234")){
			response.sendRedirect("admin.jsp");
			u.setRole("admin");
			session.setAttribute("userObj", u);
			
		}
		else{
//			out.println(u.getEmail() + " " + u.getPassword());
			u = app.validUser(username,password);
			out.println(u.getEmail() + " " + u.getPassword());
			if(u != null){
				
				session.setAttribute("userObj",u);
				response.sendRedirect("home.jsp");
			}
			else{
				session.setAttribute("msg","Invaild Username and Password");
				response.sendRedirect("login.jsp");
			}
		}
	
	}

}
