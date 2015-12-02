package serveur.serialization;

import java.io.*;

/**
 * @author tijani on 27/11/15.
 */
public class StringStream implements IStream<String> {


    private PrintStream output;
    private BufferedReader input;

    public StringStream(InputStream in, OutputStream out)
    {
        this.output = new PrintStream(out);
        this.input = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public void write(String answer) {
        output.println(answer);
        output.flush();
    }

    @Override
    public String read() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void close() {
        try {
            input.close();
            output.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
