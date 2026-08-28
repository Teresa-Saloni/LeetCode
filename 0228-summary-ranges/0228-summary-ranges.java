class Solution {
    public List<String> summaryRanges(int[] nums) {
        int j = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            if(i + 1 < nums.length && nums[i]+ 1 == nums[i+1]){
                j = i;
                while(i + 1 < nums.length && nums[i] +1 == nums[i+1])i++;
                list.add(nums[j] + "->"+nums[i]);
            }else{
                list.add(String.valueOf(nums[i]));
            }
        }
        return list;
    }
}