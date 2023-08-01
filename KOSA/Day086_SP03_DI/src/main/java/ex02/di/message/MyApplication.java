package ex02.di.message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@NoArgsConstructor
@AllArgsConstructor
public class MyApplication {

    @Setter(onMethod = @__({@Autowired, @Qualifier("twitter")}))
    private MessageService service;

    public boolean processMessage(String msg, String rec) {
        return this.service.sendMessage(msg, rec);
    }
}
