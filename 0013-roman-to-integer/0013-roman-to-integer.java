class Solution {
    public int romanToInt(String s) {
        char str[] = s.toCharArray();
        int arr[] = new int[26];
        int ans = 0;
        arr['I' - 'A'] = 1;
        arr['V' - 'A'] = 5;
        arr['X' - 'A'] = 10;
        arr['L' - 'A'] = 50;
        arr['C' - 'A'] = 100;
        arr['D' - 'A'] = 500;
        arr['M' - 'A'] = 1000;
        for(int i = 0; i < str.length;i++){
            int curr = arr[str[i] - 'A'];
            if(i+1 < str.length && curr < arr[str[i+1] - 'A'] ){
                ans = ans - curr;
            }else{
                ans += curr;
            }
        }
        return ans;
    }
}