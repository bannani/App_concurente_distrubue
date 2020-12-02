package com.enseirb.logs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class ListLogs {

    private ArrayList<Log> listlogs = new ArrayList<Log>();
    Hashtable<String, Integer> niveauDic = new Hashtable<String, Integer>();
    public ListLogs() {
		// Ajouter les logs au liste
    	listlogs.add(new Log( "DEBUG", "application1", "message1"));
    	listlogs.add(new Log("INFO", "application2", "message2"));
    	listlogs.add(new Log( "WARN", "application3", "message3"));
    	listlogs.add(new Log("ERROR", "application4", "message4"));
    	niveauDic.put("debug", 0);
    	niveauDic.put("info", 1);
    	niveauDic.put("warn", 2);
    	niveauDic.put("error", 3);
	}

    // méthode pour ajouter un log
 	public void addLog(Log log) {
 		
 		listlogs.add(log);
 	}

 	// méthode pour récuperer les logs à partir d'une X timestamp
 	public ArrayList<Log> getListByTime(float timeRefresh) {
 		ArrayList<Log> listlogsInf = new ArrayList<Log>();
 		System.out.println("Search logs by time");
 		for (Log log : listlogs) 
 		{ 
 		    if (log.timestamp>timeRefresh) {
 		    	break;
 		    }
 		 //mettre le logs comme vu
 		    if(log.nbAccess==0) log.vu=true;
 		    else log.nbAccess=0;
 		   
 		   listlogsInf.add(log);
 		    	
 		}
 		/* Sorting in decreasing order*/
 		Collections.reverse(listlogsInf);
 		
 		return listlogsInf;
 	}
 	public ArrayList<Log> getAllList() {
 		Collections.reverse(listlogs);
 		System.out.println("Search all logs");
 		return(listlogs);
 		
 	}
 	public ArrayList<Log> getListByNv(String niveau,String op) {
 		System.out.println("Search logs by niveau");
 		int indNv=niveauDic.get(niveau.toLowerCase());
 		ArrayList<Log> listlogsByNv = new ArrayList<Log>();
 		if (op.equals("max")){
 		for (Log log : listlogs) 
 		{
 			if(niveauDic.get(log.niveau.toLowerCase())>=indNv) {
 				listlogsByNv.add(log);
 			}
 		}
 		}
 		else if(op.equals("min")) {
 			for (Log log : listlogs) 
 	 		{
 	 			if(niveauDic.get(log.niveau.toLowerCase())<=indNv) {
 	 				listlogsByNv.add(log);
 	 			}
 	 		}
 		}
 		else if(op.equals("eq")) {
 			for (Log log : listlogs) 
 	 		{
 	 			if(niveauDic.get(log.niveau.toLowerCase())==indNv) {
 	 				listlogsByNv.add(log);
 	 			}
 	 		}
 		}
 		/* Sorting in decreasing order*/
 		Collections.reverse(listlogsByNv);
  	 return(listlogsByNv); 		
 	}
 	
 	public ArrayList<Log> getListByApp(String application){
 		System.out.println("Search logs by application");
 		ArrayList<Log> listlogsByApp = new ArrayList<Log>();
 		for (Log log : listlogs) 
	 		{
	 			if(log.source.equals(application)) {
	 				listlogsByApp.add(log);
	 			}
	 		}
 		/* Sorting in decreasing order*/
 		Collections.reverse(listlogsByApp);
   	 return(listlogsByApp); 	
 	}
 	
}