class Solution {
    public int majorityElement(int[] nums) {
        int p = 1, n = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(nums[i] == n) p++;
            else if(nums[i] != n && p > 0)p--;
            else{
                n = nums[i];
                p = 1;
            }
        }
        return n;
    }
}