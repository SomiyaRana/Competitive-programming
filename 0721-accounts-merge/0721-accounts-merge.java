import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        Map<String, Integer> emailMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);

            for(int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);

                if(!emailMap.containsKey(email))
                    emailMap.put(email, i);
                else
                    union(i, emailMap.get(email), parent);
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();

        for(String email : emailMap.keySet()) {
            int root = find(emailMap.get(email), parent);

            map.putIfAbsent(root, new TreeSet<>());
            map.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for(int root : map.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(root).get(0));
            temp.addAll(map.get(root));
            result.add(temp);
        }

        return result;
    }

    private int find(int x, int[] parent) {
        if(parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if(px != py)
            parent[px] = py;
    }
}