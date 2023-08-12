package edu.kosa.controller;

import edu.kosa.mapper.UserMapper;
import edu.kosa.model.UserDTO;
import edu.kosa.service.ShaEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    ShaEncoder shaEncoder;

    UserMapper userMapper;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("key", "Spring Security Test");
        return "home";
    }

    // 로그인 페이지로 이동
    @GetMapping("/user/login")
    public String login() {
        return "user/login";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/user/join")
    public String join() {
        return "user/join";
    }

    // 회원가입 처리
    @GetMapping("/user/insertUser")
    public String insertUser(@ModelAttribute UserDTO userDTO) {

        // 비밀번호 암호화
        String dbpw = shaEncoder.saltEncoding(userDTO.getPassword(), userDTO.getUserid());
        Map<String, Object> map = Map.of("userid", userDTO.getUserid(), "passwd", dbpw, "name", userDTO.getUsername(), "authority", userDTO.getAuthorities());
        return "user/insertUser";
    }

    // 관리자 영역 페이지
}
