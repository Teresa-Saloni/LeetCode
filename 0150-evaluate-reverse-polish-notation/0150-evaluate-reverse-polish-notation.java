class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case("+") : st.push(st.pop() + st.pop()); break;
                case("-") : int b = st.pop() ;int a = st.pop(); st.push(a  - b); break;
                case("*") : st.push(st.pop() * st.pop());break;
                case("/") : int c = st.pop() ; int d = st.pop(); st.push(d / c);break;
                default : st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}