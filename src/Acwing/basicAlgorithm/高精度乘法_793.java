package Acwing.basicAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高精度乘法_793 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        int[] a1 = new int[a.length()];
        for (int i = 0;i < a.length();i ++) {
            a1[i] = a.charAt(i) - '0';
        }
        int b = in.nextInt();
        Integer[] c = mul(a1, b);
        for (int i = c.length - 1;i >= 0;i --) {
            System.out.print(c[i]);
        }
    }

    private static Integer[] mul(int[] a1, int b) {
        List<Integer> c1 = new ArrayList<>();
        int t = 0;
        for (int i = a1.length - 1;i >= 0 || t > 0;i --) {
            if (i >= 0) {
                t += a1[i] * b;
            }
            c1.add(t % 10);
            t /= 10;
        }
        while (!c1.isEmpty() && c1.get(c1.size() - 1) == 0) c1.remove(c1.size() - 1);
        if (c1.isEmpty()) {
            c1.add(0);
        }
        return c1.toArray(new Integer[0]);

    }

}
