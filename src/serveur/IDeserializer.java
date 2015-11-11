package serveur;

import java.util.List;

/**
 * @author tijani on 10/11/15.
 */
public interface IDeserializer {

    public String getCommand();

    public List<String> getParams();
}
