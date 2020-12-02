package com.enseirb.servlets;

import java.io.IOException;
import java.time.Instant;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enseirb.logs.ListLogs;
import com.enseirb.logs.Log;



@WebServlet("/create-log")
public class CreateLogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	ListLogs list;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/LogCreate.jsp").forward(
				request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récuperer les informations du nouveau log
		String niveau = request.getParameter("niveau");
		String source = request.getParameter("source");
		String message = request.getParameter("message");
		if (niveau != null && !niveau.isEmpty() && source != null&& !source.isEmpty() && message != null && !message.isEmpty()) {
			// Ajouter le nouveau log
			Log log = new Log(niveau, source, message);
			list.addLog(log);
			// rediriger la requête vers la liste des logs
			response.sendRedirect(request.getContextPath() + "/logs");
		}

	}
}
