import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(0, s, dict, memo);
    }

    private List<String> dfs(int start, String s, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);

        List<String> res = new ArrayList<>();

        if (start == s.length()) {
            res.add("");  
            memo.put(start, res);
            return res;
        }

        for (String word : dict) {
            if (s.startsWith(word, start)) {
                List<String> suffixes = dfs(start + word.length(), s, dict, memo);
                for (String suf : suffixes) {
                    if (suf.isEmpty()) res.add(word);
                    else res.add(word + " " + suf);
                }
            }
        }

        memo.put(start, res);
        return res;
    }
}
