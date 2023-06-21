package edu.kosa.members;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberVO {  // Model

    // 멤버변수
    private String id, passwd, name, jumin1, jumin2, email, blog;
    private Timestamp reg_date;
}
