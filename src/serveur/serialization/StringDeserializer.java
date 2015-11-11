package serveur.serialization;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author tijani on 10/11/15.
 */
public class StringDeserializer implements IDeserializer {

    private String[] data;

    public StringDeserializer(byte[] data)
    {
        this.data = (new String(data, StandardCharsets.UTF_8)).split(" ");
    }

    @Override
    public String getCommand() {
        return data[0];
    }

    @Override
    public List<String> getParams() {
        List<String> command = Arrays.asList(data);
        return command.subList(1,command.size()-1);
    }
}
