package serveur.business.command;

import serveur.business.Table.Table;

import java.util.List;


/**
 * @author tijani on 04/11/15.
 */
public class AddCommand implements  Command {



    @Override
    public String run(List<String> params, Table table)
    {
        try {
            table.add(params.get(0), params.subList(1, params.size()));
        }
        catch (IndexOutOfBoundsException e)
        {
            return "not enough parameters";
        }
        return "name and nicknames added";
    }
}
