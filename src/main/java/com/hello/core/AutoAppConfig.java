package com.hello.core;

import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "com.hello.core.member",
        //basePackageClasses = RateDiscountPolicy.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //why Appconifg가 아니라 configuration.class?? => 기존 예제 코드 때문
public class AutoAppConfig {
    /** @ComponentScan => @Component가 붙은 클래스를 자동으로 bean으로 등록해준다.
     * 이때, 의존 관계 주입할 방법이 없으므로 주입이 필요한 부분에 @Autowired로 타입을 기준으로 찾아서 주입해준다.
     * */
}
