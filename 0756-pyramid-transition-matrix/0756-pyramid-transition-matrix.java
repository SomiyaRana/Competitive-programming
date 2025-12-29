import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build mapping: "AB" -> ['C', 'D', ...]
        for (String a : allowed) {
            String key = a.substring(0, 2);
            char top = a.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom);
    }

    private boolean dfs(String curr) {
        // If we reached the top
        if (curr.length() == 1) return true;

        List<String> nextRows = new ArrayList<>();
        buildNextRows(curr, 0, new StringBuilder(), nextRows);

        // Try all possible next rows
        for (String next : nextRows) {
            if (dfs(next)) return true;
        }

        return false;
    }

    private void buildNextRows(String curr, int index,
                               StringBuilder sb, List<String> result) {
        if (index == curr.length() - 1) {
            result.add(sb.toString());
            return;
        }

        String key = curr.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            sb.append(c);
            buildNextRows(curr, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
