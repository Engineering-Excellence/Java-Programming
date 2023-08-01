package ex01.di;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class Soccer {

    @Setter(onMethod_ = @Autowired)
    private Player player;
}
