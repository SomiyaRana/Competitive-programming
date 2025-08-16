public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Compute LIS (Longest Increasing Subsequence) for each element
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Compute LDS (Longest Decreasing Subsequence) for each element
        int[] lds = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Calculate the maximum length of a mountain array
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) { // i must be a peak
            if (lis[i] > 1 && lds[i] > 1) { // Valid peak if both sides are greater than 1
                maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
            }
        }

        // Step 4: Minimum removals needed
        return n - maxMountainLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 1};
        int[] nums2 = {2, 1, 1, 5, 6, 2, 3, 1};

        System.out.println(solution.minimumMountainRemovals(nums1)); // Output: 0
        System.out.println(solution.minimumMountainRemovals(nums2)); // Output: 3
    }
}
