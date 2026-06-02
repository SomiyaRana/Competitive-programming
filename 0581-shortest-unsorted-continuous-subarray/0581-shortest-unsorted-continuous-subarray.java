class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        int start = -1;
        int end = -2; // for already sorted case

        int max = nums[0];
        int min = nums[n - 1];

        // Traverse from left to right
        for (int i = 1; i < n; i++) {

            max = Math.max(max, nums[i]);

            // current element smaller than previous max
            if (nums[i] < max) {
                end = i;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {

            min = Math.min(min, nums[i]);

            // current element bigger than right-side minimum
            if (nums[i] > min) {
                start = i;
            }
        }

        return end - start + 1;
    }
}