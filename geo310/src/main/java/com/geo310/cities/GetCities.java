package com.geo310.cities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/cities")
public class GetCities {
	@GET
	@Produces("application/json")
	public ArrayList<String> getCities(@QueryParam("part") String part)
	{
		ArrayList<String> cities = new ArrayList<String>();
		try {
			FileReader fileCitie = new FileReader("C:\\Users\\disim\\Desktop\\geo310\\src\\main\\resources\\cities.lst");
			BufferedReader bufferreader = new BufferedReader(fileCitie);
			String line;
			while((line = bufferreader.readLine()) != null)
			{
				if(line.contains(part.toUpperCase()))
				{
					cities.add(line);
				}
			}
			
			fileCitie.close();
			
		} catch (Exception e) {
		}
		
		
		
		return cities;
	}

}
