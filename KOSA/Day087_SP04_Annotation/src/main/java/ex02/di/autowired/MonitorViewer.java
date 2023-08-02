package ex02.di.autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MonitorViewer {

    // 1. 필드에 적용
//    @Autowired
    @Setter/*(onMethod = @__(@Autowired))*/ // 3. Setter method를 통한 자동 주입
    private Recorder recorder;  // has-a

    // 2. 생성자 함수를 이용한 주입
    /*@Autowired
    public MonitorViewer(Recorder recorder) {
        this.recorder = recorder;
        log.info("생성자 메서드를 이용한 자동 주입");
    }*/

    // 4. 일반 메서드
//    @Autowired
    public void userMethod(Recorder recorder) {
        this.recorder = recorder;
        log.info("사용자(일반) 메서드를 이용한 자동 주입");
    }

    public void print() {
        log.info("user method 주입: " + this.recorder);
        recorder.show();
    }
}
