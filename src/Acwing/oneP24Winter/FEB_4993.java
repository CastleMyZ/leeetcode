package Acwing.oneP24Winter;

import java.util.Scanner;

public class FEB_4993 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取输入
        int n = in.nextInt();
        String s = in.next();

        if (s.equals(new String(new char[n]).replace('\0', 'F'))) {
            // 如果全是F，输出整个范围
            System.out.println(n);
            for (int i = 0;i < n;i ++) {
                System.out.println(i);
            }
        } else {
            // 寻找第一个和最后一个非F
            int l = 0, r = n - 1;
            while (s.charAt(l) == 'F') {
                l++;
            }
            while (s.charAt(r) == 'F') {
                r--;
            }
            int low = 0, high = 0;
            StringBuffer sb = new StringBuffer(s);
            // 计算低点
            for (int i = l;i <= r;i ++) {
                if (sb.charAt(i) == 'F') {
                    if (sb.charAt(i - 1) == 'B') {
                        sb.setCharAt(i, 'E');
                    } else {
                        sb.setCharAt(i, 'B');
                    }
                }
                if (i > l && sb.charAt(i) == sb.charAt(i - 1)) {
                    low ++;
                }
            }
            // 重置字符串
            sb = new StringBuffer(s);
            for (int i = l;i <= r;i ++) {
                if (sb.charAt(i) == 'F') {
                    sb.setCharAt(i, sb.charAt(i - 1));
                }
                if (i > l && sb.charAt(i) == sb.charAt(i - 1)) {
                    high ++;
                }
            }
            int ends = l + n - 1 - r, d = 2;
            if (ends > 0) {
                high += ends;
                d = 1;
            }

            System.out.println((high - low) / d + 1);
            for (int i = low;i <= high;i += d) {
                System.out.println(i);
            }
        }

    }
}
