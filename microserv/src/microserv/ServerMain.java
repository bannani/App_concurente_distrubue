package microserv;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {
	
	public static void main(String args[]) throws IOException{
		new ServerMain().start();
	}
	
	private int id = 0;
	
	public void start() throws IOException{
		
		try (ServerSocket serverSocket = new ServerSocket(1234)) {
			while(true) {
				System.out.println("Server : Le serveur attend une nouvelle connexion...");
				Socket socket = serverSocket.accept();
				id++;
				ClientManager clientManager = new ClientManager(socket, id);
				Thread thread = new Thread(clientManager, "ClientManager_" + id);
				System.out.println("Server : Demarrage du thread " + id);
				thread.start();
			}
		}
	}
}
