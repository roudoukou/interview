package com.atguigu.spring.circulardepend.constructorinjection;

public class ServiceB {
    private ServiceA serviceA;
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
