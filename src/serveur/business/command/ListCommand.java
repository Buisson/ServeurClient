package serveur.business.command;

import serveur.business.Table.Table;

import java.util.List;
import java.util.Map;

/**
 * @author tijani on 04/11/15.
 */
public class ListCommand implements Command {



    @Override
    public String run(java.util.List<String> params,Table table) {
        Map<String, List<String>> listAll = table.listAll();
        String answer = "listing:|";
        for(String key : listAll.keySet())
        {
            answer = answer + key + "\t" + listAll.get(key) + "|";
        }

        return answer;
    }
}
