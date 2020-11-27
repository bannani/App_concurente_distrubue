package pck;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	// Maximum number of threads in thread pool 
    static final int MAX_T = 10;
    
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		serverSocket = new ServerSocket(5000);
		
		while(true)
		{
			clientSocket = serverSocket.accept();
			ThreadClient c = new ThreadClient(clientSocket);
			pool.execute(c);
			System.out.println("client connected!");
			
		}
		

		
		
	}
}
