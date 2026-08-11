class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);
        long[] points = new long[maxVal + 1];
        for (int x : nums) points[x] += x;

        long prev2 = 0, prev1 = 0;
        for (int v = 1; v <= maxVal; v++) {
            long cur = Math.max(prev1, prev2 + points[v]);
            prev2 = prev1;
            prev1 = cur;
        }
        return (int) prev1;
    }
}