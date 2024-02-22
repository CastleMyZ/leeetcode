package Acwing.dataStructure;

import java.util.Scanner;

public class 模拟堆_839 {
    static int N = 100010,size = 1;
    static int[] heap = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            n--;
            String cd = in.next();
            if (cd.equals("I")) {
                int x = in.nextInt();
                heap[size] = x;
                down(size);
                up(size);
                size ++;
            } else if (cd.equals("PM")) {
                System.out.println(heap[1]);
            } else if (cd.equals("DM")) {
                heap[1] = heap[size --];
                down(1);
            } else if (cd.equals("D")) {
                // 在删除和修改第k个数这里犯了迷糊，不是很会
                /**
                 * 在y总这里
                 */
                int k = in.nextInt();
                heap[k] = heap[size --];
                down(k);
//                up(k);
            }else {
                int k = in.nextInt();
                int x = in.nextInt();
                heap[k] = x;
                down(k);
//                up(k);
            }
        }
    }

    private static void down(int u) {
        int t = u;
        if (u * 2 <= size && heap[u * 2] < heap[t]) t = u * 2;
        if (u * 2 + 1 <= size && heap[u * 2 + 1] < heap[t]) t = u * 2 + 1;
        if(u != t) {
            int temp = heap[u];
            heap[u] = heap[t];
            heap[t] = temp;
            down(t);
        }
    }
    private static void up(int u) {
        int t = u;
        if (u * 2 <= size && heap[u * 2] > heap[t]) t = u * 2;
        if (u * 2 + 1 <= size && heap[u * 2 + 1] > heap[t]) t = u * 2 + 1;
        if(u != t) {
            int temp = heap[u];
            heap[u] = heap[t];
            heap[t] = temp;
            up(t);
        }
    }
}
