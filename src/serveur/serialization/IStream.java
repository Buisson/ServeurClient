package serveur.serialization;

/**
 * @author tijani on 27/11/15.
 */
public interface IStream<k> {

    public void write(k answer);
    public k read();
    public void close();
}
