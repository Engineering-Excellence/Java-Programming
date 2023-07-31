package ex05.di.dao;

import ex05.di.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDAOImpl implements MemberDAO {

    private MemberDTO memberDTO;

    @Override
    public void insert() {
        log.info(memberDTO);
        System.out.println(memberDTO.getName() + " < " + memberDTO.getAge() + " < " + memberDTO.getMsg());
    }
}
