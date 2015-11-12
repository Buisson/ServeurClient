package serveur;

import serveur.business.Table.Table;
import serveur.business.command.Command;

import java.util.List;

/**
 * @author tijani on 11/11/15.
 */
public class ReflexiveUtility {


    public static String execute(String commandName, List<String> params, Table table)
    {
        try {
            commandName = "serveur.business.command." + commandName.substring(0, 1).toUpperCase() + commandName.substring(1)+"Command";
            Command command = (Command) Class.forName(commandName).newInstance();
            return command.run(params,table);
        }
        catch (ClassNotFoundException e)
        {
            return "commande introuvable";
        } catch (InstantiationException e) {
           return "la commande n'a pas pu etre instancier";
        } catch (IllegalAccessException e) {
            return "impossible d'acceder a la commande demander";
        }
    }
}
