class Solution {
    public int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int ans = 0;
        while(left < right){
            int a = Math.min(height[left],height[right]);
            ans = Math.max(a*(right - left),ans);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}