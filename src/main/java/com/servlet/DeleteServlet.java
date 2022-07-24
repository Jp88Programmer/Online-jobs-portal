package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.App;
import com.entity.Jobs;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		out.println("this is the delete page");

		int id = Integer.parseInt(req.getParameter("id"));

		out.println("this is the Id : " + id);

		Jobs job = new Jobs();

		App app = new App();

		boolean f = app.deleteJobs(id);

		HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("msg", "Job Post Delete Sucessfully...");
			res.sendRedirect("viewJobs.jsp");
		} else {
			session.setAttribute("msg", "Any Server Error Occur...");
			res.sendRedirect("viewJobs.jsp");
		}

	}

}
