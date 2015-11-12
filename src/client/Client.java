package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket myClient;
	private PrintStream output;
	private BufferedReader input;
	private String message_serveur;
	
	
	public String getMessage_serveur() {
		return message_serveur;
	}

	public Client(String machineName,int portNumber){
		try {
			myClient = new Socket(machineName,portNumber);
			output = new PrintStream(myClient.getOutputStream());
			input = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
		}
		catch (UnknownHostException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void sendMessage(String mess){
		output.println(mess);
		output.flush();
	}
	
	public boolean read(){
		try {
			message_serveur = input.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if(message_serveur!=null){
            System.out.println(message_serveur.replace("|","\n"));
            message_serveur=null;
			return true;
		}
		return false;
	}
	
}
