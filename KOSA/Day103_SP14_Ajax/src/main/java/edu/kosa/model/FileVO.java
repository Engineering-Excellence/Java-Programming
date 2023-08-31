package edu.kosa.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
public class FileVO {

    private String title;
    private String content;
}
