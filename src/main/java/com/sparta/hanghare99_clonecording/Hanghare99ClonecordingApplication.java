package com.sparta.hanghare99_clonecording;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

// DB에 데이터가 저장되거나 수정될 때 언제, 누가 했는지를 자동으로 관리
// TimeStamped null값 오류 제거하기위해 포함
@EnableJpaAuditing
@SpringBootApplication
public class Hanghare99ClonecordingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hanghare99ClonecordingApplication.class, args);
    }
    // ec2서버 서울시간으로 설정
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    }
}
