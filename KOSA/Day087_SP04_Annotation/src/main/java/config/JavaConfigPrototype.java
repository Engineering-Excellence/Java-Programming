package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springConfig.Client2;

@Configuration
public class JavaConfigPrototype {

    @Bean(initMethod = "connect", destroyMethod = "close")  // 괄호 쓰면 안 됨!
    @Scope("prototype")
    public Client2 client2() {
        Client2 client2 = new Client2();
        client2.setHost("192.168.0.115");
        return client2;
    }
}
