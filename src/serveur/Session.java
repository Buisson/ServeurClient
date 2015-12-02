package serveur;

import serveur.serialization.IStream;
import serveur.serialization.StringFormat;
import serveur.serialization.StringStream;

import java.io.IOException;
import java.net.Socket;

/**
 * @author tijani on 28/11/15.
 */
public class Session implements Runnable {

    private Serveur serveur;
    private Socket clientSocket;
    public Session(Serveur serveur,Socket clientSocket)
    {
        this.serveur = serveur;
        this.clientSocket=clientSocket;
    }

    @Override
    public void run() {

        serveur.read();
    }
}
