package com.enseirb.meteo.repository;

import java.util.Random;

@ModelWrf
public class MeteoProviderWrf implements MeteoProvider {

	public int getTemperature(String ville) {
		Random r = new Random();
		int temp = r.nextInt(24);
		return -temp;
	}
}
