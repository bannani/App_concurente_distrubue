package com.groupeonepoint.enseirb.war;

import java.util.ArrayList;

public class Users {
	private static Users singleton = new Users();
	private ArrayList<Person> persons ;
	private Users() {
		persons = new ArrayList<Person>();
		persons.add(new Person("Abdel Malick","Sidi"));
		persons.add(new Person("Bannani","Fares"));
}
	public String getString()
	{
		String s = "";
		for (Person person : persons) {
			s += "<li>" + person.toString() + "</li>";
		}
		return s;
		
	}
	public void addPerson(String nom,String prenom)
	{
		persons.add(new Person(nom,prenom));
	}
	public static Users getInstance() {
		return singleton;
	}
	
}
