package com.atguigu.spring.circulardepend;

public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        b.setA(a);
        a.setB(b);
        /*
        // 运行结果
        A create success
        B create success
         */
    }
}
