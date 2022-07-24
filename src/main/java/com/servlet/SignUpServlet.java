package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.App;
import com.entity.User;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re-password");

		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setQualifacation(qualification);
		u.setRole("user");

		HttpSession session = request.getSession();

		if (password.equals(re_password)) {

			u.setPassword(password);
			
			App app = new App();

			app.addUser(u);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Sign Up Successfully');");
			out.println("location='login.jsp';");
			out.println("</script>");

		} else {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('password and confirm password not match');");
			out.println("location='signUp.jsp';");
			out.println("</script>");

		}

	}

}
