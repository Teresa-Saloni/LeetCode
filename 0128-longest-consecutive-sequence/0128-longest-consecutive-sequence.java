class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }
        int best = 0;
        for(int n :set){
            if(set.contains(n - 1))continue;
            int length = 1;
            while(set.contains(n + length)){
                length++;
            }
            best = Math.max(best,length);
        }
        return best;
    }
}