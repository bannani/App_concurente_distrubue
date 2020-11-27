package com.enseirb.meteo.config_read_write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	public void setConfig(String s) {
		try (OutputStream output = new FileOutputStream("config.properties")) {

	         Properties prop = new Properties();

	         // set the properties value
	         prop.setProperty("meteoProvider", s);
	         

	         // save properties to project root folder
	         prop.store(output, null);

	         System.out.println(prop);

	     } catch (IOException io) {
	         io.printStackTrace();
	     }
		
	}
	public String getConfig() {
		try (InputStream input = new FileInputStream("C:/Users/bigbooss/OneDrive/Bureau/ENSEIRB/Gl Nader+Yesmine+Fares/AppConcurrentes/Meteo-Gestion-Utilisateurs/Meteo-Gestion-Utilisateurs/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value 
            return(prop.getProperty("meteoProvider"));
            

        } catch (IOException ex) {
        	System.out.println("here!!!");
            ex.printStackTrace();
            return "GFS";
        }
		
	}
	 
}
