package serveur;

import serveur.business.Table.Table;
import serveur.business.command.Command;

import java.util.List;

/**
 * @author tijani on 11/11/15.
 */
public class ReflexiveUtility {


    public static String CMD_NOT_FOUND = "commande introuvable" ;
    public static String CMD_INSTANCIATION_KO = "la commande n'a pas pu etre instancier";
    public static String CMD_ACESS_DENIED = "impossible d'acceder a la commande demander";
    public static String execute(String commandName, List<String> params, Table table)
    {
        if(commandName.length() == 0)
        {
            return "";
        }
        try {
            commandName = "serveur.business.command." + commandName.substring(0, 1).toUpperCase() + commandName.substring(1)+"Command";
            Command command = (Command) Class.forName(commandName).newInstance();
            return command.run(params,table);
        }
        catch (ClassNotFoundException e)
        {
            return CMD_NOT_FOUND;
        } catch (InstantiationException e) {
           return CMD_INSTANCIATION_KO;
        } catch (IllegalAccessException e) {
            return CMD_ACESS_DENIED;
        }
    }
}
