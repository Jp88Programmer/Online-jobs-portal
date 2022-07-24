package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.App;
import com.entity.Jobs;

/**
 * Servlet implementation class EditJobsServlet
 */
public class EditJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditJobsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		
		out.println("this is the edit page");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		out.println("the id : " + id);
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		String status = req.getParameter("status");
		String location = req.getParameter("location");

		Jobs job = new Jobs();
		
		job.setId(id);
		job.setTitle(title);
		job.setCategory(category);
		job.setDescription(description);
		job.setLocation(location);
		job.setStatus(status);
		App app = new App();
		
		app.editJobs(job);
		
		out.println("Data edit Sucessfully...");
		
		RequestDispatcher rd = req.getRequestDispatcher("viewJobs.jsp");
		rd.forward(req, res);

	}

}
