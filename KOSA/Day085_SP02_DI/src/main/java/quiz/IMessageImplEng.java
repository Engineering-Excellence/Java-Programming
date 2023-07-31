package quiz;

import lombok.Setter;

@Setter
public class IMessageImplEng implements IMessage {

    private String engMsg;

    @Override
    public void sayHello() {
        System.out.println(this.engMsg);
    }
}
