import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2;
        int left = mid - 1;   // end of smaller half
        int right = n - 1;    // end of larger half

        // Fill even indices (small values)
        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[left--];
        }

        // Fill odd indices (large values)
        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[right--];
        }
    }
}