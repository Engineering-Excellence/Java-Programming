package DI_05_Spring;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton {

    private static final Singleton instance = new Singleton();
}
