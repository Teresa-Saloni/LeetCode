class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List <int[]> res = new ArrayList<>();
        int curr[] = intervals[0];
        res.add(curr);
        for(int[] next : intervals){
            if(next[0] <= curr[1]){
                curr[1] = Math.max(next[1],curr[1]);
            }else{
                curr = next;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}