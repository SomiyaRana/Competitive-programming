public class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        if (n < 3) return 0;

        // first and last occurrence of each letter
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; ++i) {
            first[i] = -1;
            last[i] = -1;
        }

        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int result = 0;
        // For each character as outer char 'c'
        for (int ch = 0; ch < 26; ++ch) {
            if (first[ch] == -1 || first[ch] == last[ch]) continue; // no pair of ch
            boolean[] seen = new boolean[26];
            // count distinct chars between first[ch] and last[ch]
            for (int k = first[ch] + 1; k < last[ch]; ++k) {
                seen[s.charAt(k) - 'a'] = true;
            }
            for (int x = 0; x < 26; ++x) {
                if (seen[x]) result++;
            }
        }
        return result;
    }

    // Simple test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countPalindromicSubsequence("abca")); // 3 -> "aba","aca","aaa"? Actually here: "aba","aca" and maybe "aaa" not present so answer 2 (example)
        System.out.println(sol.countPalindromicSubsequence("aabca")); // example tests
        System.out.println(sol.countPalindromicSubsequence("aaa")); // 1 -> "aaa"
    }
}
