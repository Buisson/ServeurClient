package serveur.serialization;

import java.util.List;

/**
 * @author tijani on 10/11/15.
 */
public interface IFormat {

    public String getCommand();

    public List<String> getParams();
}
