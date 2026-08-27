class Solution {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftmax = 0;
        int rightmax = 0;

        int ans = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (leftmax >= height[left]) {
                    ans += leftmax - height[left];
                } else {
                    leftmax = height[left];
                }

                left++;       // ✅ move left only

            } else {

                if (rightmax >= height[right]) {
                    ans += rightmax - height[right];
                } else {
                    rightmax = height[right];
                }

                right--;      // ✅ move right only
            }
        }

        return ans;
    }
}