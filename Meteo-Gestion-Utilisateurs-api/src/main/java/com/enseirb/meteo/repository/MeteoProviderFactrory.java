package com.enseirb.meteo.repository;

import java.lang.module.Configuration;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.enseirb.meteo.config_read_write.Config;

public class MeteoProviderFactrory {
	@Inject
	private  Config config;
    @Inject @ModelGfs MeteoProvider meteoProviderGfs;
    @Inject @ModelWrf MeteoProvider meteoProviderWrf;
    @Produces MeteoProvider getProvider() {
        String modelType = config.getConfig();
        if (modelType.equals("WRF")) return meteoProviderWrf;
        else if  (modelType.equals("GFS")) return meteoProviderGfs;
        else throw new IllegalArgumentException("Unknown ModelType: " + modelType);
        
    }


}
