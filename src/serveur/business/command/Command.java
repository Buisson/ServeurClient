package serveur.business.command;


import serveur.business.Table.Table;

/**
 * @author tijani on 04/11/15.
 */
public abstract class Command<k> {

    private Table table;

    public Command(Table table)
    {
        this.table = table;
    }

  public abstract String run (k params);

    public Table getTable() {
        return table;
    }
}
