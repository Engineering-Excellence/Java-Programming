package springConfig;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Log4j2
@Data
public class Client implements InitializingBean, DisposableBean {

    private String defaultHost;
    private String host;

    public Client() {
        log.info("Client 기본 생성자 호출");
    }

    public Client(String defaultHost) {
        this.defaultHost = defaultHost;
        log.info("Client 생성자: " + defaultHost);
    }

    public void send() {    // <property name="host" value="localhost"/>
        log.info("Client.send() to " + defaultHost);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*
            초기화 메서드(이벤트를 내부적으로 가지고 자동 호출: 호출시점)
            InitializingBean에 대한 구현부
            afterPropertiesSets: property injection 후에
         */
        log.info("afterPropertiesSet() 실행");
    }

    @Override
    public void destroy() throws Exception {    // ctx.close()
        /*
            소멸 메서드
            DisposableBean에 대한 구현부
         */
        log.info("destroy() 실행");
    }
}
