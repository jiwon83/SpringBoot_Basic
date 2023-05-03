package com.hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) //why Appconifg가 아니라 configuration.class?? => 기존 예제 코드 때문
public class AutoAppConfig {

}
