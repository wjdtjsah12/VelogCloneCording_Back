package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.SignupDto;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입 시 이메일 중복 및 아이디 검사, 비밀번호 암호화
    public void registerUser(SignupDto signupDto){
        //패스워드 암호화
        signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        checkEmail(signupDto.getEmail());
        checkUserId(signupDto.getUserId());

        User user = new User(signupDto);
        userRepository.save(user);
    }
    //이메일 중복 확인 함수
    public void checkEmail(String email){
        Optional<User> foundEmail = userRepository.findByEmail(email);
        if (foundEmail.isPresent()){
            throw new IllegalArgumentException("중복된 이메일 입니다.");
        }
    }
    //아이디 중복 확인 함수
    public void checkUserId(String userId){
        Optional<User> foundUserId = userRepository.findByUserId(userId);
        if (foundUserId.isPresent()){
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }
    }



}
