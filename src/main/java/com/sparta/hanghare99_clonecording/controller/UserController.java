package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.ErrorMessageDto;
import com.sparta.hanghare99_clonecording.dto.SignupDto;
import com.sparta.hanghare99_clonecording.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // json으로 데이터를 주고 받을 때 사용
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //urlDto를 받으신 이유가 뭐지? url 값을 받아서

    //회원가입
    @PostMapping("/user/signup")
    public ErrorMessageDto registerUser(@RequestBody SignupDto signupDto){
        System.out.println(signupDto.getUsername());
        System.out.println(signupDto.getUserId());
        System.out.println(signupDto.getEmail());
        System.out.println(signupDto.getPassword());
        System.out.println(signupDto.getIntroduce());
        System.out.println(signupDto.getProfileNum());

        try {
            userService.registerUser(signupDto); // 중간에 에러가 발생하면 서비스에서 처리한 에러메세지를 받음.
        }catch (Exception e){
            String error = e.getMessage();

            ErrorMessageDto errorMessageDto = new ErrorMessageDto("NG",error);
            System.out.println("signup NG");
            return errorMessageDto;
        }
        ErrorMessageDto errorMessageDto = new ErrorMessageDto("Ok", "null");
        System.out.println("signup OK");
        return errorMessageDto;

    }

//    //로그아웃
//    @PostMapping("/user/logout")
//    public urlDto logout(){
//        return new urlDto("/");
//    }
}
