package Acwing.dataStructure;

import java.util.Scanner;
import java.util.Stack;

public class 单调栈_830 {
    static int idx, N = 10010;
    static int[] nums;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        nums = new int[n];
        for (int i = 0;i < n;i ++) {
            nums[i] = in.nextInt();
            if (stk.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                while (!stk.isEmpty() && stk.peek() >= nums[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(stk.peek() + " ");
                }
            }
            stk.push(nums[i]);
        }


    }
}
