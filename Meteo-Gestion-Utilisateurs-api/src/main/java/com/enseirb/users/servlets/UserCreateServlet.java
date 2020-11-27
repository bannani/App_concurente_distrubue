package com.enseirb.users.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.enseirb.users.repository.Users;

@WebServlet("/meteo/create-user")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/UserCreate.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// récuperer les informations du nouveau utilisateur
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");

		if (prenom != null && !prenom.isEmpty() && nom != null
				&& !nom.isEmpty()) {
			// Ajouter le nouveau utilisateur
			Users.getInstance().addPerson(prenom, nom,mdp);
			// rediriger la requête vers la liste des utilisateur
			response.sendRedirect(request.getContextPath() + "/meteo/login");
		}

	}

}
