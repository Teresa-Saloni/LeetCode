class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;   // push what we EXPECT to see
                case '[': stack.push(']'); break;
                case '{': stack.push('}'); break;
                default:
                    // closer: stack must be non-empty and top must match
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();   // nothing left unclosed
    }
}