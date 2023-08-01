package ex01.di;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Curling {

    @Setter(onMethod_ = {@Autowired, @Qualifier("m2")})
    private Player player;
}
