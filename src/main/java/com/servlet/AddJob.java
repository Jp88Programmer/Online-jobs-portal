package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.db.App;
import com.entity.Jobs;

/**
 * Servlet implementation class AddJob
 */
//@WebServlet(urlPatterns = "/processServlet")
public class AddJob extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	PrintWriter out = response.getWriter();
    	 String title = req.getParameter("title");
    	 String description = req.getParameter("description");
    	 String category = req.getParameter("category");
    	 String status = req.getParameter("status");
    	 String location = req.getParameter("location");
    	 
    	 Jobs job = new Jobs();
    	 
    	
        	job.setTitle(title);
        	job.setCategory(category);
        	job.setDescription(description);
        	job.setLocation(location);
        	job.setStatus(status);
//        	job.setPdate(new Timestamp(new Date().getTime()));
        	App app = new App();
        	
        	app.addJobs(job);
        	

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Add Data Sucessfully');");
			out.println("location='viewJobs.jsp';");
			out.println("</script>");

//        	System.out.println("Add data successfully..");
        	
//        	out.println("Add Data Sucessfully...");
    	 
	}

}
