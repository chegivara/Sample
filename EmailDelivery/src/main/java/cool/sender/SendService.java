package cool.sender;

import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

public interface SendService {
    public void init() throws UnknownHostException;
    public  boolean send( String from, String to) throws IOException;
}
