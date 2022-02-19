package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.SignupDto;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입 시 이메일 중복 및 아이디 검사, 비밀번호 암호화
    public void registerUser(SignupDto signupDto) {
        //성명
        String username = signupDto.getUsername();
        //이메일
        String email= checkEmail(signupDto);
        //아이디
        String userId=checkUserId(signupDto);
        //비밀번호
        String password=signupDto.getPassword();
        //소개
        String introduce= signupDto.getIntroduce();
        //프로필넘버
        int profileNum = signupDto.getProfileNum();

        //패스워드 암호화
        String encodepassword = passwordEncoder.encode(signupDto.getPassword());

        User user = new User(username, email, userId, encodepassword, introduce, profileNum);
        userRepository.save(user);
    }
    //이메일 중복 확인 함수
    public String checkEmail(SignupDto signupDto){
        String email = signupDto.getEmail();
        Optional<User> foundEmail = userRepository.findByEmail(email);
        if (foundEmail.isPresent()){
            throw new IllegalArgumentException("중복된 이메일 입니다.");
        }
        return email;
    }
    //아이디 중복 확인 함수
    public String checkUserId(SignupDto signupDto){
        String userId = signupDto.getUserId();
        Optional<User> foundUserId = userRepository.findByUserId(userId);
        if (foundUserId.isPresent()){
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }
        return userId;
    }



}
