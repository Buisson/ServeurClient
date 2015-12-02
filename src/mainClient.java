import java.net.SocketException;
import java.util.Scanner;

import client.Client;

import java.util.regex.*;

public class mainClient {

	public static void main(String[] args) {
		Scanner readUserCommand = new Scanner(System.in);
		
		System.out.println("##BEGIN TEST CLIENT");
		Pattern pattern=Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}"); //regexp IP
		Pattern patternInt=Pattern.compile("[0-9]+"); //regexp IP
	    
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
	    int port=2000;
	    System.out.println("Veuillez rentrer le numero de port (rentrer le numero port par defaut 2000)");
		String temp = readUserCommand.nextLine();
		Matcher matcherint = patternInt.matcher(temp);
		
		while(!matcherint.matches()){
			if(temp.isEmpty()){
				break;
			}
			System.out.println("Veuillez entrer un numero de port valide");
			temp = readUserCommand.next();
			matcherint = patternInt.matcher(temp);
		}
            if(!temp.equals(""))
			port = Integer.parseInt(temp);
		
		readUserCommand = new Scanner(System.in);
		
	    Client c = new Client(ipConf,port);
        String commandToSend = "";
		while(!commandToSend.equals("quit")){
			System.out.println("Veuillez entrer une commande :");
			commandToSend = readUserCommand.nextLine();

			c.sendMessage(commandToSend);
			while(!c.read());
			
		}
        c.close();
	}
}