import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {

            // Count frequency in this subarray
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Put entries into a list
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()}); // {value, count}
            }

            // Sort by freq desc, value desc
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1]; // freq desc
                return b[0] - a[0]; // value desc
            });

            // Take top x most frequent
            int sum = 0;
            int taken = 0;
            for (int[] p : list) {
                if (taken == x) break;
                sum += p[0] * p[1];
                taken++;
            }

            ans[i] = sum;
        }

        return ans;
    }
}
