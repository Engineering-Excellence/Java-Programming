package springConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Setter
public class Client2 {

    private String host;

    public void connect() throws Exception {
        log.info("Client2.connect() to " + host);
    }

    public void send() {
        log.info("Client2.send() to " + host);
    }

    public void close() throws Exception {
        log.info("Client2.close() to " + host);
    }
}
