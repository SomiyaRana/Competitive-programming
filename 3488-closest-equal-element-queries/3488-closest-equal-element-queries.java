import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);
            int size = list.size();

            int prev = list.get((pos - 1 + size) % size);
            int next = list.get((pos + 1) % size);

            int dist1 = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
            int dist2 = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));

            ans.add(Math.min(dist1, dist2));
        }

        return ans;
    }
}