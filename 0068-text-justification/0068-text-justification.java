class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int j = i, lineLen = 0;

            // pack words greedily
            while (j < n && lineLen + words[j].length() + (j-i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            // last line OR single word -> left justify
            if (j == n || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            }
            else {
                int totalSpaces = maxWidth - lineLen;
                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    sb.append(" ".repeat(spaceEach + (k - i < extra ? 1 : 0)));
                }
                sb.append(words[j-1]); // last word no trailing spaces here
            }

            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
