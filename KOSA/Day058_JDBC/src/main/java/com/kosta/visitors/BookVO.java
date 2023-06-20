package com.kosta.visitors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookVO {

    private int num;
    private String name, email, home, contents;
}
