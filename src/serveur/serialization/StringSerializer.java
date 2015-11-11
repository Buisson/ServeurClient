package serveur.serialization;

/**
 * @author tijani on 11/11/15.
 */
public class StringSerializer implements ISerializer {

    private String answer;

    public StringSerializer(String answer) {
        this.answer = answer;
    }

    @Override
    public byte[] serialize() {
        return answer.getBytes();
    }
}
