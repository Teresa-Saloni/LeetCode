class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currend = 0, far=0;
        for(int i = 0; i < nums.length -1;i++){
            far = Math.max(far,i + nums[i]);
            if(i == currend){
                jumps++;
                currend = far;
            }
        }
        return jumps;
    }
}