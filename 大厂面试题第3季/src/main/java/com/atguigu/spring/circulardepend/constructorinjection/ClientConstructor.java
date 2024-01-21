package com.atguigu.spring.circulardepend.constructorinjection;

public class ClientConstructor {
    public static void main(String[] args) {
        // new ServiceA(new ServiceB(new ServiceA(???)));
    }
}
