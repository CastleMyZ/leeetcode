package Acwing.dataStructure;

import java.util.Scanner;

public class Trie字符串统计_835 {
    static int N = 100010, idx;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            n--;
            String command = in.next();
            switch (command) {
                case "I":
                    String s = in.next();
                    insert(s);
                    break;
                case "Q":
                    String st = in.next();
                    System.out.println(query(st));
                    break;
            }
        }
    }

    private static int query(String st) {
        int p = 0;
        for (int i = 0;i < st.length();i ++) {
            char c = st.charAt(i);
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++ idx;
            p = son[p][u];
        }
        return cnt[p];
    }

    private static void insert(String s) {
        int p = 0;
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++ idx;
            p = son[p][u];
        }
        cnt[p] ++;
    }
}
