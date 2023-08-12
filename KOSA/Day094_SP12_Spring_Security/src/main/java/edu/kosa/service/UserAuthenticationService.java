package edu.kosa.service;

import edu.kosa.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//로그인 처리 클래스
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserAuthenticationService implements UserDetailsService {

    private SqlSessionTemplate sqlSession;

    @Override
    public UserDetails loadUserByUsername(String userid)
            throws UsernameNotFoundException {
        //사용자 아이디 확인
        Map<String, Object> user = sqlSession.selectOne("user.selectUser", userid);
        //아이디가 없으면 예외 발생
        if (user == null) throw new UsernameNotFoundException(userid);

        //사용권한 목록
        List<GrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString())); //필드명은 대문자로
        return new UserDTO(user.get("USERNAME").toString(),
                user.get("PASSWORD").toString(),
                (Integer) Integer.valueOf(user.get("ENABLED").toString()) == 1,
                true, true, true, authority,
                user.get("USERNAME").toString());
    }
}
