package ex03.di.qualifier;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Recorder {

    public void show() {
        log.info("Recorder show()");
    }
}
