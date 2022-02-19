package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.SignupRequestDto;
import com.sparta.hanghare99_clonecording.dto.SignupResponseDto;
import com.sparta.hanghare99_clonecording.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user/signup")
    public SignupResponseDto registerUser(@RequestBody SignupRequestDto requestDto){
        return userService.registerUser(requestDto);
    }
}
