package Acwing.dataStructure;
import java.io.*;
import java.util.Scanner;

public class 滑动窗口_154 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 对输入数据进行初始化
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0;i < n;i ++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] ans = new int[n];
        int tt = 0, hh = 0;
        // 查找最小值
        for(int i = 0;i < n;i ++) {
            if (hh <= tt && i - k + 1 > ans[hh]) {
                hh++;
            }
            while (hh <= tt && a[i] <= a[ans[tt]]) {
                tt--;
            }
            ans[++tt] = i;
            if (i + 1 >= k) {
                log.write(a[ans[hh]] + " ");
            }
        }
        log.write("\n");
        tt = 0;
        hh =0;
        for(int i = 0;i < n;i ++) {
            if (hh <= tt && i - k + 1 > ans[hh]) {
                hh++;
            }
            while (hh <= tt && a[i] >= a[ans[tt]]) {
                tt--;
            }
            ans[++tt] = i;
            if (i + 1 >= k) {
                log.write(a[ans[hh]] + " ");
            }
        }
        // 关闭输入输出流
        log.flush();
        reader.close();
        log.close();
    }

}
