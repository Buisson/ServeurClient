package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket myClient;
	
	
	public Client(String machineName,int portNumber){
		try {
			myClient = new Socket(machineName,portNumber);
		}
		catch (UnknownHostException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
}
