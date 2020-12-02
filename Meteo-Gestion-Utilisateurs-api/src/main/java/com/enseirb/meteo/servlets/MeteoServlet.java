package com.enseirb.meteo.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enseirb.meteo.config_read_write.Config;
import com.enseirb.meteo.repository.MeteoProvider;
import com.enseirb.meteo.repository.ModelWrf;

@WebServlet("/meteo")
public class MeteoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String METEO = "ModelWrf";// ((config.getConfig().equals("Wrf")) ? "ModelWrf" :"ModelGfs");

	@Inject
	@ModelWrf
	private MeteoProvider meteoProvider;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("nom") == null) {

			response.sendRedirect(request.getContextPath() + "/meteo/login");
		}

		request.getRequestDispatcher("/WEB-INF/MeteoDisplay.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupérer le nom de la ville
		String ville = request.getParameter("ville");
		int cityFound = 0;
		try {
			FileReader fileCitie = new FileReader(
					"C:\\Users\\disim\\Desktop\\geo310\\src\\main\\resources\\cities.lst");
			BufferedReader bufferreader = new BufferedReader(fileCitie);
			String line;
			while ((line = bufferreader.readLine()) != null) {
				if (line.equals(ville.toUpperCase())) {
					cityFound = 1;
					break;
				}
			}

			fileCitie.close();

		} catch (Exception e) {
		}
		// récupérer la température de la ville
		int meteo = meteoProvider.getTemperature(ville);

		// envoyer les données
		request.setAttribute("ville", ville);
		request.setAttribute("cityFound", cityFound);
		request.setAttribute("meteo", meteo);
		HttpSession session = request.getSession();
		int n = (int) session.getAttribute("accessNumber");
		n++;
		session.setAttribute("accessNumber", n);
		request.getRequestDispatcher("WEB-INF/MeteoDisplay.jsp").forward(request, response);

	}

}
