package edu.kosa.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    // 회원가입
    int insertUser(Map<String, Object> map);

    // 로그인
    Map<String, Object> selectUser(String userId);
}
