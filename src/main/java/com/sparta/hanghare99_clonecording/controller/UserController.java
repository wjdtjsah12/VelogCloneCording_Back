package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.ErrorMessageDto;
import com.sparta.hanghare99_clonecording.dto.IsLoginDto;
import com.sparta.hanghare99_clonecording.dto.SignupDto;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.security.provider.UserDetailsImpl;
import com.sparta.hanghare99_clonecording.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        System.out.println(signupDto.getNickname());
        System.out.println(signupDto.getPassword());
        System.out.println(signupDto.getIntroduce());

        try {
            userService.registerUser(signupDto); // 중간에 에러가 발생하면 서비스에서 처리한 에러메세지를 받음.
        }catch (Exception e){
            String error = e.getMessage();

            ErrorMessageDto errorMessageDto = new ErrorMessageDto("NG",error);
            System.out.println("signup NG");
            return errorMessageDto;
        }
        ErrorMessageDto errorMessageDto = new ErrorMessageDto("OK", "null");
        System.out.println("signup OK");
        return errorMessageDto;

    }

    //로그인 유저 확인
    @PostMapping("/islogin")
    public IsLoginDto userLoginCheck(@AuthenticationPrincipal UserDetailsImpl userDetails){
        System.out.println(userDetails);
            User username = userDetails.getUser();
            return new IsLoginDto(
                    username.getId(),
                    username.getUsername(),
                    username.getUseride(),
                    username.getNickname(),
                    username.getIntroduce(),
                    username.getProfileNum()
            );
    }

    //로그인
//    @PostMapping("/user/login")
//    public

//    //로그아웃
//    @PostMapping("/user/logout")
//    public urlDto logout(){
//        return new urlDto("/");
//    }
}
