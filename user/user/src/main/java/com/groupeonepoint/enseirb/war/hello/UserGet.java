package com.groupeonepoint.enseirb.war.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeonepoint.enseirb.war.Users;


@WebServlet(name="UserGet", urlPatterns="/users")
public class UserGet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1> Listes des utilisateurs </h1>" );
		out.println("<ul>");
		out.println(Users.getInstance().getString());
		out.println("</ul>");
		out.println("<a href=\'http://localhost:8080/meteo/UserPost\'>Nouveau</a>");
		
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
