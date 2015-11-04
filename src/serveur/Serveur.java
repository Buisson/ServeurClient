package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	private ServerSocket service;
	private Socket clientSocket = null;
	
	
	public Serveur(){
		try {
			service = new ServerSocket(2000);
			clientSocket = service.accept();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
}
