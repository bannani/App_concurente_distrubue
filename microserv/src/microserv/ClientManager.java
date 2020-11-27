package microserv;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class ClientManager implements Runnable {
	
	private final int id;
	private final Socket socket;
	
	private final String SPACE = " ";
	private final String INTER = "\\?";
	private final String EQUAL = "="; 

	public ClientManager(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			System.out.println("Client["+id+"] Debut de traitement");
			List<String> header = readHeader();
			writeResponse(header);
			socket.close();
			System.out.println("Client["+id+"] Fin de traitement");
		} catch (IOException e) {
			throw new IllegalStateException("Le client " + id + " est en erreur" , e);
		}
	}

	private void writeResponse(List<String> header) throws IOException {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write("HTTP/1.1 200 OK\n\n");

			Thread.sleep(30);
			writer.write("<h1>Hello</h1>");
			writer.write("Je suis le client " + id+"<br>");

			String request = header.get(0).split(SPACE)[1].substring(1);
			String filename = request.split(INTER)[0];
			String name = request.split(INTER)[1].split(EQUAL)[1];

			File myObj = new File(filename);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        writer.write(data.replace("${name}", name));
		     }
		    myReader.close();
			writer.flush();
		} catch (InterruptedException e) {
			throw new IllegalStateException("Le thread a été interrompu");
		}
	}

	private List<String> readHeader() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		List<String> header = new ArrayList<>();
		String headerLine = reader.readLine();
		while (headerLine != null && !headerLine.isEmpty()) {
			header.add(headerLine);	
			headerLine = reader.readLine();
		}
		if (headerLine==null) {
			String message = "Client " + socket.getInetAddress() + " send incomplete header";
			throw new IOException(message);
		}
		return 	header;
	}

}
