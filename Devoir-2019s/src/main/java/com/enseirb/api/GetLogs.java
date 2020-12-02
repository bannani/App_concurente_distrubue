package com.enseirb.api;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.enseirb.logs.ListLogs;
import com.enseirb.logs.Log;

@Path("/log")
public class GetLogs {
	
	@Inject 
	ListLogs logs;
	
	@GET
    @Produces("application/json")
    public ArrayList<Log> getLogs(@QueryParam("level")  String level,@QueryParam("minLevel")  String minLevel,@QueryParam("appli")  String appli,@QueryParam("maxAge")  float maxAge) {
        if (level!=null) return  logs.getListByNv(level,"eq");
        else if (minLevel!=null) return (ArrayList<Log>) logs.getListByNv(minLevel,"min");
        else if (appli!=null) return (ArrayList<Log>) logs.getListByApp(appli);
        else if (maxAge!=0.0f)return (ArrayList<Log>) logs.getListByTime(maxAge);
        else return (ArrayList<Log>) logs.getAllList();
    }
	
	
	@POST
	@Consumes("application/json")
	public String newLog(
	    @QueryParam("niveau") String niveau,
	    @QueryParam("source") String source,
	    @QueryParam("message") String message){
		logs.addLog(new Log(niveau,source,message));;
	    return "log added !";
	 }

}
