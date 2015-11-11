import client.Client;
import serveur.Serveur;


public class main {

	public static void main(String[] args) {
		System.out.println("##BEGIN TEST SERVEUR");
		Serveur s = new Serveur();
		while(true){
			s.read();
		}
	}

}
