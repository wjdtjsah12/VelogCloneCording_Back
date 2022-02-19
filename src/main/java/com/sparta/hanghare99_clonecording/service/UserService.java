package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.SignupRequestDto;
import com.sparta.hanghare99_clonecording.dto.SignupResponseDto;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public SignupResponseDto registerUser(SignupRequestDto requestDto) {
        User user = new User(requestDto);
        userRepository.save(user);

        Long registerUserId = user.getId();
        String statusHttp = "OK";
        String errorMessage = null;
        // 테스트용 임시 ResposneDto

        return new SignupResponseDto(registerUserId, statusHttp, errorMessage);
    }
}
