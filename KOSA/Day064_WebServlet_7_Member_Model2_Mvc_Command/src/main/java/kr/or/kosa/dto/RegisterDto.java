package kr.or.kosa.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
create table mvcregister(
 id number constraint pk_mvcregister_id primary key,
 pwd varchar2(20) not null,
 email varchar2(50) not null
)

*/

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RegisterDto {

    private int id;
    private String pwd;
    private String email;
}
