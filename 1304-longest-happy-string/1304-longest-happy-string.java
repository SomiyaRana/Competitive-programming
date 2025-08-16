public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        
        int[][] letters = {{a, 'a'}, {b, 'b'}, {c, 'c'}};

        while (true) {
            java.util.Arrays.sort(letters, (x, y) -> y[0] - x[0]);

            boolean added = false;

            for (int i = 0; i < 3; i++) {
                int count = letters[i][0];
                char ch = (char) letters[i][1];

                int len = result.length();
                if (count > 0 && (len < 2 || result.charAt(len - 1) != ch || result.charAt(len - 2) != ch)) {
                    result.append(ch);
                    letters[i][0]--;  
                    added = true;
                    break;
                }
            }

            if (!added) {
                break;
            }
        }

        return result.toString();
    }
}
