class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int ma = nums[0];
        int s = 0,r = 0;
        for( int i = 1; i < nums.length;i++){
            ans += nums[i];
            if(ans < nums[i]){
                ans = nums[i];
            }
            ma = Math.max(ans,ma);
        }
        return ma;
    }
}