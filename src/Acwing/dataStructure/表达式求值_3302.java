package Acwing.dataStructure;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 常考计算器
 */

public class 表达式求值_3302 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        Stack<Integer> nums = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0;i < n;i ++) {
            char c = s.charAt(i);
            // 判断c是不是数字
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + (s.charAt(j) - '0');
                    j++;
                }
                nums.push(x);
                i = j - 1;
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    eval(nums, op);
                }
                op.pop();
            } else {
                // 正常字符
                while (!op.isEmpty() && op.peek() != '(' && map.get(op.peek()) >= map.get(c)) {
                    eval(nums, op);
                }
                op.push(c);
            }
        }
        while (!op.isEmpty())   {
            eval(nums, op);
        }
        System.out.println(nums.peek());
    }

    private static void eval(Stack<Integer> nums, Stack<Character> op) {
        int b = nums.pop();
        int a = nums.pop();
        char c = op.pop();
        if (c == '+') {
            a += b;
        } else if (c == '*'){
            a *= b;
        } else if (c == '/') {
            a /= b;
        } else {
            a -= b;
        }
        nums.push(a);
    }
}
