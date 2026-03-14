import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        long lastUsed = Long.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            long low = (long)num - k;
            long high = (long)num + k;

            long candidate = Math.max(low, lastUsed + 1);

            if (candidate <= high) {
                lastUsed = candidate;
                count++;
            }
        }

        return count;
    }
}