package L_1_100;
import java.util.*;
public class letter_combinations_phone_number_17 {
    class Solution {
        // 存储结果的列表，每个字符串代表一种组合
        List<String> ans = new ArrayList<>();
        // 输入的数字字符串长度
        int n;
        // 临时存储当前组合的字符串
        StringBuffer sb = new StringBuffer();

        // 主方法，返回给定数字字符串的所有字母组合
        public List<String> letterCombinations(String digits) {
            // 如果输入为空，则直接返回结果列表
            if(digits.length() == 0)    return ans;
            // 定义一个字符串数组，每个数字对应一个字母集合
            String[] numstring = {"", "","abc","def","ghl","jkl","mno","pqrs","tuv","wxyz"};
            // 调用深度优先搜索方法
            dfs(0, numstring, digits);
            // 返回所有字母组合
            return ans;
        }

        // 深度优先搜索方法，使用回溯的思想来生成所有可能的字母组合
        public void dfs(int idx, String[] numstring, String digits) {
            // 如果当前组合的长度等于输入数字字符串的长度，则将组合添加到结果列表中
            if(sb.length() == digits.length()) {
                ans.add(new String(sb));
                return;
            }
            // 获取当前数字对应的字母集合
            String now = numstring[digits.charAt(idx) - '0'];
            // 遍历当前字母集合中的每个字母，并递归调用dfs方法
            for(int i = 0;i < now.length();i ++) {
                sb.append(now.charAt(i));  // 将当前字母添加到临时组合中
                dfs(idx + 1, numstring, digits);  // 递归调用，处理下一个数字字符
                sb.deleteCharAt(sb.length() - 1);  // 回溯，移除临时组合中的最后一个字母，尝试其他可能的组合
            }
        }
    }
}
