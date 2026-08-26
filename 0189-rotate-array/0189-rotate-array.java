class Solution {
    public void rev(int arr[],int a, int b){
        while(b >= a){
            int c = arr[b];
            arr[b] = arr[a];
            arr[a] = c;
            b--;
            a++; 
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length -1);
    }
}
