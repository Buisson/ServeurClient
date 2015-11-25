import serveur.Serveur;
import serveur.business.Table.Table;
import serveur.serialization.StringFormat;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class main {

	public static void main(String[] args) {
		System.out.println("##BEGIN TEST SERVEUR");
		Serveur s = new Serveur(new Table(new HashMap<String, List<String>>()),new StringFormat("list"));
		while(true){
			s.read();
		}
	}

}
