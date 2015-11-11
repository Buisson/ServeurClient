package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {
	private ServerSocket service;
	private Socket clientSocket = null;
	private PrintStream output;
	private BufferedReader input;
	private String message_distant;
	
	public Serveur(){
		try {
			service = new ServerSocket(2000);
			clientSocket = service.accept();
			output = new PrintStream(clientSocket.getOutputStream());
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void sendResponse(String mess){
		output.println(mess);
		output.flush();
	}
	
	public void read(){
		try {
			message_distant = input.readLine();
		} 
		catch (IOException e) {e.printStackTrace();}
		
		if(message_distant!=null){
			System.out.println(message_distant);
			sendResponse("OK BIEN RECU!");
		}
	}
	
}
