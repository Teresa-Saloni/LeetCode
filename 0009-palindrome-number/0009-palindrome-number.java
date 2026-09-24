class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        int in = 0;
        int y = x;
        while(y > 0){
            int d = y %10;
            in = in * 10 + d;
            y = y / 10;
        }
        return in == x; 
    }
}