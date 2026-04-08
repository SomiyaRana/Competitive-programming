import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // Step 1: Flip negative numbers
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // Step 2: Sort again to find smallest element
        Arrays.sort(nums);

        // Step 3: If k is odd, flip smallest element
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        // Step 4: Calculate sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}