import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        if (!dict.contains(endWord)) return ans;

        Map<String, List<String>> parents = new HashMap<>();

        // BFS queue
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // Track visited words for the current BFS layer
        Set<String> visitedThisLevel = new HashSet<>();
        Set<String> visitedGlobal = new HashSet<>();
        visitedGlobal.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            visitedThisLevel.clear();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                char[] arr = word.toCharArray();
                for (int p = 0; p < arr.length; p++) {
                    char original = arr[p];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[p] = c;
                        String next = new String(arr);

                        if (dict.contains(next)) {
                            if (!visitedGlobal.contains(next)) {
                                if (!visitedThisLevel.contains(next)) {
                                    visitedThisLevel.add(next);
                                    q.add(next);
                                }
                                parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            }

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    arr[p] = original;
                }
            }

            visitedGlobal.addAll(visitedThisLevel);
        }

        if (!found) return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, ans);

        return ans;
    }

    private void backtrack(String word, String beginWord, 
                           Map<String, List<String>> parents,
                           List<String> path, 
                           List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> res = new ArrayList<>(path);
            Collections.reverse(res);
            ans.add(res);
            return;
        }

        if (!parents.containsKey(word)) return;

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
