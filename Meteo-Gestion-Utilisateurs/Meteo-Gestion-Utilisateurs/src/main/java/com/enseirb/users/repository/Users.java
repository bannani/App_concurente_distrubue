package com.enseirb.users.repository;

import java.util.ArrayList;

import com.enseirb.users.entities.Person;

public class Users {
	private static Users singleton = new Users();
	private ArrayList<Person> persons ;
	private Users() {
		persons = new ArrayList<Person>();
		persons.add(new Person("admin","admin","admin"));
		persons.add(new Person("Abdel Malick","Sidi","sidi"));
		persons.add(new Person("Bannani","Fares","fares"));
}
	public ArrayList<Person> getList()
	{
		return persons;
		
	}
	public void addPerson(String nom,String prenom,String mdp)
	{
		persons.add(new Person(nom,prenom,mdp));
	}
	public static Users getInstance() {
		return singleton;
	}
	
}
