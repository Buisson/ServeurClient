import java.util.Scanner;

import client.Client;
import java.util.regex.*;

public class mainClient {

	public static void main(String[] args) {
		Scanner readUserCommand = new Scanner(System.in);
		
		System.out.println("##BEGIN TEST CLIENT");
		Pattern pattern=Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}"); //regexp IP
	    
		System.out.println("Veuillez rentrer l'IP du serveur (taper entrer pour avoir l'adresse IP par defaut 127.0.0.1)");
		String ipConf = readUserCommand.nextLine();
		Matcher matcher = pattern.matcher(ipConf);
	    
	    while(!matcher.matches()){
	    	System.out.println("##"+ipConf+"##");
	    	if(ipConf.isEmpty()){
	    		ipConf="127.0.0.1";
	    		break;
	    	}
	    	System.out.println("Veuillez entrer une IP valide");
	    	ipConf = readUserCommand.nextLine();
	    	matcher = pattern.matcher(ipConf);
	    }
	    
	    //System.out.println("ipConf : "+ipConf);
	    Client c = new Client(ipConf,2000);
		
		while(true){
			System.out.println("Veuillez entrer une commande :");
			String commandToSend = readUserCommand.nextLine();
			c.sendMessage(commandToSend);
			while(!c.read());
		}
	}
}