class Solution {
    public String simplifyPath(String path) {
        Deque <String> st = new ArrayDeque<>();
        for(String p : path.split("/")){
            if(p.isEmpty() || p.equals(".")) continue;
            if(p.equals("..")) st.pollLast();
            else st.addLast(p);
        }
        return "/"+ String.join("/",st);
    }
}