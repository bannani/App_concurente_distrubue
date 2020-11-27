package com.enseirb.users.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enseirb.users.entities.Person;
import com.enseirb.users.repository.Users;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/meteo/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/logIn.jsp").forward(
				request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");
		
		
		ArrayList<Person> users= Users.getInstance().getList();
		for(Person u:users)
		{
			System.out.println(u.testLogIN(nom,mdp));
			if(u.testLogIN(nom,mdp)) {
				HttpSession session = request.getSession();
				session.setAttribute("nom", nom);
				session.setAttribute("accessNumber", 0);
				
				response.sendRedirect(request.getContextPath() + "/meteo");
			}
		}
		request.setAttribute("msglog", "votre mdp est incorrect");
		request.getRequestDispatcher("/WEB-INF/logIn.jsp").forward(
				request, response);
	}

}
