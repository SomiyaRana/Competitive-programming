class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int[] ans = new int[n];

        int start = 0;
        int currMax = nums[0];

        for (int i = 0; i < n - 1; i++) {
            currMax = Math.max(currMax, nums[i]);

            // No inversion across boundary => separate component
            if (currMax <= suffixMin[i + 1]) {

                int compMax = currMax;

                for (int j = start; j <= i; j++) {
                    ans[j] = compMax;
                }

                start = i + 1;

                if (start < n) {
                    currMax = nums[start];
                }
            }
        }

        // Last component
        currMax = nums[start];
        for (int i = start; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = currMax;
        }

        return ans;
    }
}