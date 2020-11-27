package pck;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient  implements Runnable {
	Socket clientSocket = null;
	ThreadClient(Socket c)
	{
		this.clientSocket=c;
	}
	
	public void run() {
		PrintWriter out;
		try {
			out = new PrintWriter(clientSocket.getOutputStream());
			out.println("HTTP/1.1 200 OK");
			out.println("Content-Type: text/html");
			out.println("\r\n");
			out.println("<p> Hello world </p>");
			out.flush();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
