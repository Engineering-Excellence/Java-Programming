package ex01.di;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Basketball {

    @Setter(onMethod_ = {@Autowired, @Qualifier("player2")})
    private Player player;
}
