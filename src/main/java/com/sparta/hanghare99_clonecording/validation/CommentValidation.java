package com.sparta.hanghare99_clonecording.validation;

import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;

public class CommentValidation {
    public static void validationCommentRegister(CommentRegisterDto requestDto) {
        String content = requestDto.getContent();
        // content 확인
        // 공백, null 입력 제한
        if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해 주세요.");
        }
    }
}
