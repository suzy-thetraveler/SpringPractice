package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //Thread A 사용자 1000원 주문
        int userA = statefulService1.order("UserA", 1000);

        //Thread B 사용자 2000원 주문
        int userB = statefulService2.order("UserB", 2000);

        //Thread A 주문조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);
    }
    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}