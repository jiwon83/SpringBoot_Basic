package com.hello.core.singeton;

import org.junit.jupiter.api.Test;

public class StatefulService { //test 생성 단축키 ctrl + shift + t
    private int price; //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = "+ name + " price = "+ price);
        this.price = price;
        //return price;
    }

    public int getPrice() {
        return price;
    }

}
