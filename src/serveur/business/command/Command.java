package serveur.business.command;


import serveur.business.Table.Table;

import java.util.List;

/**
 * @author tijani on 04/11/15.
 */
public interface Command {


  public String run (List<String> params, Table table);
}
