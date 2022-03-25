package com.sparta.re_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class ReBlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReBlogApplication.class, args);
    }

    @PostConstruct //배포 후 수정사항이 있어 수정 후 재배포시, 시간 오류로 인한 오름차순 정렬이 깨지기 때문에, 이를 사용함
    public void started(){ TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")); }

}

//수정 할 것
//1. 삭제 기능
//2. 수정 기능
//3. 상단 배너 클릭 시 메인페이지로 이동
//4. css 손 볼 것
//5. 회원가입, 로그인 기능 추가 해보자!
