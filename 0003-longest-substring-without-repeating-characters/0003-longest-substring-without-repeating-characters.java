class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0,ans = 0;
        int arr[] = new int[128];
        for(int j = 0; j < s.length();j++){
            char c = s.charAt(j);
            arr[c]++;
            while(arr[c] > 1){
                arr[s.charAt(i)]--;
                i++;
            }
            ans = Math.max(ans,j - i + 1);
        }
        return ans;
    }
}