import client.Client;


public class mainClient {

	public static void main(String[] args) {
		System.out.println("##BEGIN TEST CLIENT");
		Client c = new Client("127.0.0.1",2000);
		c.sendMessage("sendMessage");
	}

}
