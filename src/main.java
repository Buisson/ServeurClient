import client.Client;
import serveur.Serveur;


public class main {

	public static void main(String[] args) {
		System.out.println("##BEGIN TEST CLIENT/SERVEUR");
		Serveur s = new Serveur();
		Client c = new Client("127.0.0.1",2000);
		
		
	}

}
