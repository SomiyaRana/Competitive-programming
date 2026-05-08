import java.util.*;

class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {

        int n = nums.length;

        if (n % k != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Always start from smallest number
        while (!map.isEmpty()) {

            int first = map.firstKey();

            // Try to form consecutive group
            for (int i = 0; i < k; i++) {

                int curr = first + i;

                if (!map.containsKey(curr)) {
                    return false;
                }

                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
            }
        }

        return true;
    }
}