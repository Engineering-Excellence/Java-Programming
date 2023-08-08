package com.model;

import java.util.List;

public interface MemberDAO {

    // 회원 상세 조회
    MemberVO selectMemberById(String id);

    List<MemberVO> selectAllMembers();

    // 회원 유무 조회
    boolean memberCheck(String id, String pwd);

    boolean memberInsert(MemberVO member);
}
