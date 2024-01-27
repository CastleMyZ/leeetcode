package Acwing.basicAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高精度除法_794 {
    static int yu;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int[] a = new int[s.length()];
        for (int i = 0 ;i < s.length();i ++) {
            a[i] = s.charAt(i) - '0';
        }
        int b = in.nextInt();
        Integer[] c = div(a, b);
        for (int i = 0;i < c.length;i ++) {
            System.out.print(c[i]);
        }
        System.out.println();
        System.out.println(yu);
    }

    private static Integer[] div(int[] a, int b) {
        List<Integer> sc = new ArrayList<>();
        int r = 0;
        for (int i =0;i < a.length;i ++) {
            r = r * 10 + a[i];
            sc.add(r / b);
            r = r % b;
        }
        yu = r;
        while (!sc.isEmpty() && sc.get(0) == 0) sc.remove(0);
        return sc.toArray(sc.toArray(new Integer[0]));
    }
}
