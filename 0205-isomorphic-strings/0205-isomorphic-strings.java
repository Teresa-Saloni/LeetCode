class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> ms = new HashMap<>();
        HashMap<Character,Character> mt = new HashMap<>();
        for(int i = 0;i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(ms.containsKey(a) && ms.get(a) != b) return false;
            if(mt.containsKey(b) && mt.get(b) != a) return false;
            ms.put(a,b);
            mt.put(b,a);
        }
        return true;
    }
}