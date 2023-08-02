package ex04.di.resource;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Log4j2
public class MonitorViewer {

    private Recorder recorder;  // has-a

    @Resource(name = "z") // name
//    @Resource(name = "r3")  // id
//    @Resource
//    @Qualifier("y")
    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;

        boolean record = Resource.class.getTypeName().contains("record1");
        log.info(record);

        log.info(Resource.class.getCanonicalName().equals("record1"));

        recorder.show();
        log.info(recorder);
        log.info("@Resource injection");
    }
}
