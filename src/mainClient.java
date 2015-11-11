import java.util.Scanner;

import client.Client;


public class mainClient {

	public static void main(String[] args) {
		System.out.println("##BEGIN TEST CLIENT");
		Client c = new Client("127.0.0.1",2000);
		Scanner readUserCommand = new Scanner(System.in);
		
		while(true){
			System.out.println("Veuillez entrer une commande :");
			String commandToSend = readUserCommand.nextLine();
			c.sendMessage(commandToSend);
			while(!c.read());
		}
	}

}
