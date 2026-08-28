class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;   // ⚠️ don't forget

        Map<Character, String> mapPW = new HashMap<>();
        Map<String, Character> mapWP = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (mapPW.containsKey(c) && !mapPW.get(c).equals(w)) return false;
            if (mapWP.containsKey(w) && mapWP.get(w) != c) return false;

            mapPW.put(c, w);
            mapWP.put(w, c);
        }
        return true;
    }
}