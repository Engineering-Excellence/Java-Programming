package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springConfig.Client;

@Configuration  // Java 기반 설정 파일
public class JavaConfig {

    @Bean
    public Client client() {
        return new Client("127.0.0.1");
    }
}
