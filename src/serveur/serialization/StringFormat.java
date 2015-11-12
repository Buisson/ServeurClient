package serveur.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tijani on 10/11/15.
 */
public class StringFormat implements IFormat {

    private String[] data;

    public StringFormat(String data)
    {
        this.data = data.split(" ");
    }

    @Override
    public String getCommand() {
        return data[0];
    }

    @Override
    public List<String> getParams() {
        List<String> command = new ArrayList<String>(Arrays.asList(data));

        if(command.size() == 1)
        {
            return new ArrayList<String>();
        }
        else {
            return command.subList(1, command.size());
        }
    }
}
