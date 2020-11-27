package com.enseirb.users.entities;

public class Person {
	private String nom;
	private String prenom;
	private String mdp;
	
	
	public Person(String nom, String prenom,String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mdp=mdp;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return nom + "     " + prenom ;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Boolean testLogIN(String nom,String mdp)
	{
		System.out.println(nom+"  "+mdp);
		if(this.nom.equals(nom) && this.mdp.equals(mdp)) {
			return true;
		}
		return false;
	}
}
