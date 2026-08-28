class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int ans[] = new int[26];
        for(int i = 0;i < s.length();i++){
            ans[s.charAt(i) - 'a']++;
        }
        for(int j = 0; j < s.length();j++){
            if(ans[t.charAt(j) - 'a'] >= 1){
                ans[t.charAt(j) - 'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}