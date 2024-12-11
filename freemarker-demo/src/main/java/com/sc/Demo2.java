package com.sc;

public class Demo2 {
    public static void main(String[] args) {
        // divideByFive();
        multiplyTable();
        triangle();
    }

    // 输出1 - 1000之间可以被5整除的数
    public static void divideByFive() {
        int lineNum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 5 ==0) {
                if (lineNum == 3) {
                    System.out.println();
                    lineNum = 0;
                }
                System.out.print(i + ", ");
                lineNum++;
            }
        }
    }

    public static void multiplyTable() {
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i*j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void triangle() {
        for (int i = 1; i <= 5; i++) {
            for (int i1 = 5; i1 >= i; i1--) {
                System.out.print(" ");
            }
            for (int i1 = 1; i1 <= i; i1++) {
                System.out.print("*");
            }
            for (int i1 = 1; i1 < i; i1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
