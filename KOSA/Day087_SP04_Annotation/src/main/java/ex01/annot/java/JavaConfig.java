package ex01.annot.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JavaConfig {   // xml 설정파일 역할  ex) ctx.xml

    @Bean
    public MyCats cat1() {  // MyCats cat1 = new MyCats();  / <bean id="cat1" class="ex01.annot.java.MyCats">

        List<String> hobbies = List.of("뒹굴기", "앞발들기");
        MyCats myCats = new MyCats("냥이", 12, hobbies);
        myCats.setWeight(3.0);
        myCats.setColor("black");

        return myCats;
    }

    @Bean
    public MyCats cat2() {

        List<String> hobbies = List.of("윙크하기", "잠자기");
        MyCats myCats = new MyCats("딩거", 3, hobbies);
        myCats.setWeight(7.7);
        myCats.setColor("black");

        return myCats;
    }

    @Bean
    public Cats catsInfo() {
        return new Cats(cat1());
    }
}
