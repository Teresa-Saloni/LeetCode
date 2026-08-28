class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char ans[] = s.toCharArray();
            Arrays.sort(ans);
            String key = new String(ans);
            map.computeIfAbsent(key,k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}