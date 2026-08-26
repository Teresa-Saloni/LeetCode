class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int p = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
                p = 0;
            }else if(nums[i] == nums[i-1] && p != 2){
                nums[k] = nums[i];
                p = 2;
                k++;
            }
        }
        return k;
    }
}