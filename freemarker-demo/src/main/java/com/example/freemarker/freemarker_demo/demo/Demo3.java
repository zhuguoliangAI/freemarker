package com.example.freemarker.freemarker_demo.demo;

public class Demo3 {
    public static void main(String[] args) {
        int i = 10;
        int i2 = 010; // 八进制 0
        int i3 = 0x10; // 十六进制 0x

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);

        // 浮点数

        // 字符
        char c1  = 'a';

        System.out.println(c1);
        System.out.println((int) c1); // 编码问题

        char c3 = '\u0061';
        System.out.println(c3);


        int money = 1_000_000;
        System.out.println(money);
    }

    /**
     *
     * @param name
     * @throws Exception
     */
    public static void name(String name) throws Exception {
        System.out.println(name);
    }
}
