package Acwing.basicAlgorithm;

import java.util.Scanner;

public class 二进制中1的个数_801 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int[] a = new int[n];
        for (int i =0 ;i < n;i ++) {
            int x = in.nextInt();
            int count = 0;
            while (x != 0) {
                count ++;
                x -= bit(x);
            }
            System.out.print(count + " ");
        }


    }
    public static int bit(int x) {
        return x & -x;
    }
//    java中把统计二进制个数方法封装在jdk中了，可以直接调用Integer类中的bitCount方法
//import java.io.BufferedInputStream;
//import java.util.Scanner;
//
//    public class Main {
//
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//            int n = scanner.nextInt();
//            for(int i=0;i<n;i++) {
//                System.out.print(Integer.bitCount(scanner.nextInt())+" ");
//            }
//            scanner.close();
//        }
//
//    }
}
