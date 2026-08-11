class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        int prev2 = 1, prev1 = 1; // dp[0], dp[1]
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if (oneDigit != 0) cur += prev1;
            if (twoDigit >= 10 && twoDigit <= 26) cur += prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}