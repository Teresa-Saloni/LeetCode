class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            // Greedily pick words for this line
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            int gaps = numWords - 1;
            StringBuilder line = new StringBuilder();

            boolean lastLine = (j == n);
            if (lastLine || gaps == 0) {
                // Left-justify: single spaces, pad the end
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(' ');
                }
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } else {
                // Full-justify: distribute spaces across gaps
                int totalWordChars = lineLen - gaps;      // chars excluding the single spaces
                int totalSpaces = maxWidth - totalWordChars;
                int base = totalSpaces / gaps;            // every gap gets at least this
                int extra = totalSpaces % gaps;           // leftmost 'extra' gaps get one more

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spaces = base + (k - i < extra ? 1 : 0);
                        for (int sp = 0; sp < spaces; sp++) {
                            line.append(' ');
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }
        return result;
    }
}