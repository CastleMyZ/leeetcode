public class LongestSubstringOfReturns5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0,start = 0,end = 0;
        char[] sc = s.toCharArray();
        for(int i = 0;i < n;i ++) {
            int len1 = expand(sc, i , i);
            int len2 = expand(sc, i, i + 1);
            int t = Math.max(len1, len2);
            if(ans < t) {
                ans = t;
                start = i - (ans - 1) / 2;
                end = i + ans / 2;
            }
        }
        return s.substring(start + 1, end);
    }
    public int expand(char[] sc, int left, int right) {
        while(left >= 0 && right < sc.length && sc[left] == sc[right]) {
            left --;
            right ++;
        }
        return right - left + 1;
    }
}

