class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count the last word
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}