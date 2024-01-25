package Acwing.basicAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class add_high {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int[] a = new int[s1.length()];
        int idx = 0;
        for (int i = s1.length() - 1;i >= 0;i --) {
            a[idx ++] = s1.charAt(i) - '0';
        }
        int[] b = new int[s2.length()];
        idx = 0;
        for (int i = s2.length() - 1;i >= 0;i --) {
            b[idx ++] = s2.charAt(i) - '0';
        }
        Integer[] c = add(a, b);
        for (int i = c.length - 1;i >= 0;i --) {
            System.out.print(c[i] + " ");
        }

    }
    public static Integer[] add(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int i = 0;i < a.length || i < b.length; i ++) {
            if (i < a.length)   t += a[i];
            if (i < b.length)   t += b[i];
            res.add(t % 10);
            t /= 10;
        }
        if (t > 0) {
            res.add(t);
        }
        Integer[] c = res.toArray(new Integer[0]);
       return c;
    }


}
