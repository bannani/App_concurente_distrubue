package com.enseirb.meteo.rest_api;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.w3c.dom.Text;

import com.enseirb.meteo.repository.MeteoProvider;
import com.enseirb.meteo.repository.ModelWrf;
import com.enseirb.users.entities.Person;
import com.enseirb.users.repository.Users;

@Path("/users")

public class Users_api {
    
    @GET
    @Path("/getList")
    @Produces("application/json")
    public ArrayList<Person> hello() {
     ArrayList<Person> list =Users.getInstance().getList();
      return list;
    }
        
    @POST
    @Path("/addUser")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/json")
    public String newUser(
            @QueryParam("prenom") String prenom,
            @QueryParam("nom") String nom,
            @QueryParam("mdp") String mdp){
        Users.getInstance().addPerson(prenom, nom,mdp);
        return "user added !";

    }

}