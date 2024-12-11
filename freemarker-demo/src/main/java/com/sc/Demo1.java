package com.sc;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        // 输入多个数字 求和、平均数 每输入一个数字用回车确认   输入非数字来结束输入
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int num = 0;

        while (scanner.hasNextDouble()) {
            double nextDouble = scanner.nextDouble();
            sum += nextDouble;
            num++;
        }

        System.out.println(sum);

        System.out.println(sum/num);

        scanner.close();
    }
}
