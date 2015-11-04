package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket myClient;
	private PrintStream output;
	private BufferedReader input;
	
	
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
	
}
