package com.hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //ElementType.TYPE은 클래스, 인터페이스, 열거 타입(enum) 선언 시 사용ok
@Retention(RetentionPolicy.RUNTIME)
public @interface MyIncludeComponent {
}
