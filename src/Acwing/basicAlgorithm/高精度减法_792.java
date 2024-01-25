package Acwing.basicAlgorithm;
import java.util.*;
public class 高精度减法_792 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

        // 将字符串逆序转换为整数数组 A 和 B
        List<Integer> A = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            A.add(a.charAt(i) - '0');
        }

        List<Integer> B = new ArrayList<>();
        for (int i = b.length() - 1; i >= 0; i--) {
            B.add(b.charAt(i) - '0');
        }

        // 调用 sub 函数进行两个整数数组的相减
        List<Integer> C = cmp(A, B) ? sub(A, B) : sub(B, A);

        // 输出结果
        if (!cmp(A, B)) {
            System.out.print('-');
        }

        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
        System.out.println();
    }

    // 比较两个整数数组的大小
    public static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) {
            return A.size() > B.size();
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            if (!A.get(i).equals(B.get(i))) {
                return A.get(i) > B.get(i);
            }
        }

        return true;
    }

    // 对两个整数数组进行相减
    public static List<Integer> sub(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        for (int i = 0, t = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);
            if (t < 0) t = 1;
            else t = 0;
        }

        // 去除高位多余的零
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }

}
