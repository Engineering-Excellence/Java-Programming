package ex05.di.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDTO {

    private String name;
    private int age;
    private String msg;

    public MemberDTO() {
        log.info("MemberDTO 기본 생성자");
    }
}
