package com.enseirb.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enseirb.logs.ListLogs;
import com.enseirb.logs.Log;


/**
 * Servlet implementation class DisplayLogs
 */
@WebServlet("/logs")
public class DisplayLogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	ListLogs list;
	
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listLogs", list.getListByTime(System.currentTimeMillis()));
		
		request.getRequestDispatcher("/WEB-INF/LogDisplay.jsp").forward(
				request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String niveau = request.getParameter("niveau");
		String source = request.getParameter("source");
		String flush = request.getParameter("flush");
		if (niveau!=null) request.setAttribute("listLogs", list.getListByNv(niveau,"max"));
        else if (source!=null) request.setAttribute("listLogs", list.getListByApp(source));
        else request.setAttribute("listLogs", list.getListByTime(System.currentTimeMillis()));
		if(flush!=null) {
			try {
				File ff = new File("C:\\log-"
						+ System.currentTimeMillis() + ".log");
				ff.createNewFile();
				FileWriter ffw = new FileWriter(ff);
				ffw.write("Timestamp Niveau Source Message");
				for (Log log : list.getAllList()) {
					if ((Instant.now().getNano() - log.getTimestamp()) >= 500) {
						ffw.write(log.getTimestamp() + " " + log.getNiveau()
								+ " " + log.getSource() + " "
								+ log.getMessage());
						ffw.write("\n");
					}
				}
				request.setAttribute("bloqued", "bloqued");
				ffw.close();
			} catch (Exception e) {
			}
		}
		request.getRequestDispatcher("/WEB-INF/LogDisplay.jsp").forward(
				request, response);
	}

}
