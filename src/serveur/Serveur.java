package serveur;

import serveur.business.Table.Table;
import serveur.serialization.IFormat;
import serveur.serialization.IStream;
import serveur.serialization.StringFormat;
import serveur.serialization.StringStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {
	private ServerSocket service;
    private Table table;
    private IFormat format;

	public ServerSocket getService() {
		return service;
	}

	public Serveur(Table table, IFormat format){
		try {
			this.service = new ServerSocket(2000);
            this.table = table;
            this.format = format;

		}
		catch (IOException e) {e.printStackTrace();}
	}


	public void read(){
            try {
                Socket clientSocket = service.accept();
                IStream<String> stream = new StringStream(clientSocket.getInputStream(),clientSocket.getOutputStream());
                new Thread(new Session(this,clientSocket)).start();
                String message;
                while ((message = stream.read()) != null) {
                    System.out.println("Message recu du client : "+message);
                    format = new StringFormat(message);
                    stream.write(ReflexiveUtility.execute(format.getCommand(), format.getParams(), table));
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }




    public Table getTable() {
        return table;
    }

    public IFormat getFormat() {
        return format;
    }

    public void setFormat(IFormat format) {
        this.format = format;
    }
}
