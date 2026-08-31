class Solution {
    public boolean isValid(String s) {
        Deque <Character> st = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            switch (c){
                case '{' : st.push('}');break;
                case '(' : st.push(')');break;
                case '[' : st.push(']');break;
                default:
                    if(st.isEmpty() || st.pop() != c) return false;
            }
        }
        return st.isEmpty();
    }
}