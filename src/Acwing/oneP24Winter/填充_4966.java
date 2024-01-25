package Acwing.oneP24Winter;

import java.util.Scanner;

public class 填充_4966 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int res = 0;
        for (int i = 0;i < s.length() - 1;i ++) {
            char a = s.charAt(i), b = s.charAt(i + 1);
            if (a == b || a == '?' || b == '?') {
                res ++;
                i++;
            }
        }
        System.out.println(res);
    }
}
