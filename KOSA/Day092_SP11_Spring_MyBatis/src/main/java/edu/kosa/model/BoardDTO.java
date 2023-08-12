package edu.kosa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private int num;
    private String name, email, pwd, subject, content, ip;
    private java.sql.Date regDate;
    private int hit, parent, sort, tab;
}
