package Acwing.dataStructure;

import java.io.*;
import java.util.Scanner;

public class KMP_831 {
//    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String p = in.next();
        p = " " + p;
        int m = in.nextInt();
        String s = in.next();
        s = " " + s;
        int[] ne = new int[n + 1];
        for (int i = 2,j = 0;i <= n;i ++) {
            while (j > 0 && p.charAt(i) != p.charAt(j + 1)) j = ne[j];
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            ne[i] = j;
        }
        for (int i = 1,j = 0;i <= m;i ++) {
            while (j > 0 && s.charAt(i) != p.charAt(j + 1))    j = ne[j];
            if (s.charAt(i) == p.charAt(j + 1)) j ++;
            if (j == n) {
                System.out.print(i - n + " ");
                j = ne[j];
            }
        }
    }
}
