class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0;
        int maxsum = nums[0];
        int minsum = nums[0];
        int currmin = 0;
        for(int i = 0 ;i < nums.length;i++){
            total += nums[i];
            currMax = Math.max(nums[i],currMax + nums[i]);
            maxsum = Math.max(currMax,maxsum);
            currmin = Math.min(nums[i],currmin + nums[i]);
            minsum = Math.min(currmin,minsum);
        }
        if(maxsum < 0){
            return maxsum;
        }
        return Math.max(maxsum , total - minsum);
    }
}