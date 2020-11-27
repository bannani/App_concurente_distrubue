package com.groupeonepoint.enseirb.war.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeonepoint.enseirb.war.Users;


@WebServlet(name="UserPost", urlPatterns="/UserPost")
public class UserPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPost() {
        super();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<form Method=\"POST\" Action=\"\">");
		out.println("Prenom :<input type='text' placeholder='Prenom' name='firstname' />" );
		out.println("</br>");
		out.println("Nom :<input type='text' placeholder='Nom' name='name' />" );
		out.println("</br>");
		out.println("<input type='submit' value='Post' name='submit' />" );
		out.println("</form>" );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users.getInstance().addPerson(request.getParameter("name"), request.getParameter("firstname"));
		request.getRequestDispatcher("/users").forward(request, response);
	}

}
