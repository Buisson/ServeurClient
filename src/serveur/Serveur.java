package serveur;

import serveur.business.Table.Table;
import serveur.serialization.IFormat;
import serveur.serialization.StringFormat;

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
    private Table table;
    private IFormat format;
	
	public Serveur(Table table, IFormat format){
		try {
			this.service = new ServerSocket(2000);
			this.clientSocket = service.accept();
			this.output = new PrintStream(clientSocket.getOutputStream());
			this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.table = table;
            this.format = format;

		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void sendResponse(String mess){
		output.println(mess);
		output.flush();
	}
	
	public void read(){
		try {
            String message = input.readLine();
            if(message != null) {
                format = new StringFormat(message);
                sendResponse(ReflexiveUtility.execute(format.getCommand(), format.getParams(), table));
            }
		} 
		catch (IOException e) {e.printStackTrace();}


	}
	
}
