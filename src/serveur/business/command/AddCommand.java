package serveur.business.command;

import serveur.business.Table.Table;

import java.util.List;


/**
 * @author tijani on 04/11/15.
 */
public class AddCommand extends Command<List<String>> {


    public AddCommand(Table table) {
        super(table);
    }

    @Override
    public String run(List<String> params)
    {
        try {
            this.getTable().add(params.get(0), params.subList(1, params.size() - 1));
        }
        catch (IndexOutOfBoundsException e)
        {
            return "not enough parameters";
        }
        return "name and nicknames added";
    }
}
