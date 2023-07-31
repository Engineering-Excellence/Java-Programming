package quiz;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IMessageImplKor implements IMessage {

    private String korMsg;

    @Override
    public void sayHello() {
        System.out.println(this.korMsg);
    }
}
