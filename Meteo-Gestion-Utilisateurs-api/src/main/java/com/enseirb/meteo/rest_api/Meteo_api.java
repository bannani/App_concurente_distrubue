package com.enseirb.meteo.rest_api;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.enseirb.meteo.repository.MeteoProvider;
import com.enseirb.meteo.repository.ModelWrf;
import com.enseirb.users.entities.Person;
import com.enseirb.users.repository.Users;

@Path("/meteo")
public class Meteo_api {
	@Inject
    @ModelWrf
    private MeteoProvider meteoProvider;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int meteo(@QueryParam("ville")  String ville){
	    int meteoville = meteoProvider.getTemperature(ville);
	    return meteoville;
	}

}
