package com.atguigu.spring.circulardepend.setinjection;

public class ClientSet {
    public static void main(String[] args) {
        ServiceAA aa = new ServiceAA();
        ServiceBB bb = new ServiceBB();

        bb.setServiceAA(aa);
        aa.setServiceBB(bb);

        // 运行结果
        /*
        B里面设置了A
        A里面设置了B
         */
    }
}
