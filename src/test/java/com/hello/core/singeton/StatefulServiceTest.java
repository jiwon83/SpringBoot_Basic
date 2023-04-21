package com.hello.core.singeton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 패턴의 주의사항 : to avoid Stateful Service")
    void statefulServiceSingletol(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        statefulService.order("userA",10000);

        //ThreadB : B사용자가 25000원 주문
        statefulService.order("userB",25000);

        //ThreadA : 사용자 A 주문 금액 조회
        int price = statefulService.getPrice();
        //Assertions.assertFalse(price==25000);
        org.assertj.core.api.Assertions.assertThat(price).isEqualTo(25000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}