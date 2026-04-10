import java.util.*;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices for each value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: check triplets
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 3) continue;

            for (int i = 0; i < size - 2; i++) {
                for (int k = i + 2; k < size; k++) {
                    int dist = 2 * (list.get(k) - list.get(i));
                    minDist = Math.min(minDist, dist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}