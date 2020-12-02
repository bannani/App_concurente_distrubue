package com.enseirb.logs;

import java.time.Instant;

public class Log {
	public float timestamp;
	public String niveau;
	public String source;
	public String message;
	public boolean vu;
	public int nbAccess;
	public Log(String niveau,String source,String message){
		this.timestamp=Instant.now().getNano();
		this.vu= false;
		this.nbAccess=1;
		this.message=message;
		this.source=source;
		this.niveau=niveau;		
	}
	public float getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isVu() {
		return vu;
	}
	public void setVu(boolean vu) {
		this.vu= vu;
	}
	

}
