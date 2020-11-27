package com.enseirb.meteo.repository;

import java.util.Random;

@ModelGfs
public class MeteoProviderGfs implements MeteoProvider {

	public int getTemperature(String ville) {
		Random r = new Random();
		int temp = r.nextInt(24);
		return temp;
	}
}
