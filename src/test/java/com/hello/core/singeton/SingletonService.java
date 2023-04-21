package com.hello.core.singeton;

public class SingletonService {
    private SingletonService(){}
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 호출.");
    }
}
