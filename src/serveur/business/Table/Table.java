package serveur.business.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tijani on 04/11/15.
 */
public class Table {

    private Map<String,List<String>> associations;

    public Table(Map<String, List<String>> associations) {
        this.associations = associations;
    }

    public List<String> list(String name)
    {
        return associations.get(name);
    }

    public Map<String,List<String>> listAll()
    {
       return  associations;
    }

    public void add(String name, List<String> nicknames)
    {
        if(associations.get(name) != null) {
            associations.get(name).addAll(nicknames);
        }
        else
        {
            associations.put(name,nicknames);
        }
    }
}
