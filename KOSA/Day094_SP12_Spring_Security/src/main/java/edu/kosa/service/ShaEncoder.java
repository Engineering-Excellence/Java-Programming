package edu.kosa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service //service bean으로 등록
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ShaEncoder {
    // security-context.xml에 선언된 passwordEncoder bean 주입
//    @Resource(name="passwordEncoder")
//    @Qualifier("passwordEncoder")
    ShaPasswordEncoder encoder;

    public String encoding(String str) {
        return encoder.encodePassword(str, null);
    }

    public String saltEncoding(String str, String salt) {
        return encoder.encodePassword(str, salt);
    }
}
