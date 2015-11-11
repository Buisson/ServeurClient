package serveur.business.command;

import serveur.business.Table.Table;

import java.util.List;
import java.util.Map;

/**
 * @author tijani on 04/11/15.
 */
public class ListCommand extends Command<List<String>> {


    public ListCommand(Table table) {
        super(table);
    }

    @Override
    public String run(List<String> params) {
        Map<String,List<String>> listAll = this.getTable().listAll();
        String answer = "listing ; \n";
        for(String key : listAll.keySet())
        {
            answer = key + "\t" + listAll.get(key) + "\n";
        }
        return answer;
    }
}
