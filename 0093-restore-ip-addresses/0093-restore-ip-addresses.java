import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(String s, int idx, List<String> path, List<String> res) {
        if (path.size() == 4) {
            if (idx == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) break;

            String part = s.substring(idx, idx + len);

            
            if (part.length() > 1 && part.charAt(0) == '0') break;

            if (Integer.parseInt(part) > 255) break;

            path.add(part);
            backtrack(s, idx + len, path, res);
            path.remove(path.size() - 1);
        }
    }
}
