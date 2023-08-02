package ex03.di.qualifier;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Log4j2
public class MonitorViewer {

    @Setter(onMethod_ = {@Autowired, @Qualifier("recorder1")})
    private Recorder recorder;  // has-a

    /*
        //    @inject
        @Autowired(required = false)    // default: required = true
        public monitorViewer(@Qualifier("key") recorder recorder) {
            this.recorder = recorder;
            log.info("@autowired 자동 주입");
        }
    */

    public void show() {
        recorder.show();
        log.info("MonitorViewer show()");
    }
}
