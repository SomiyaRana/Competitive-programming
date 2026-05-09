import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        // fix largest side
        for (int k = n - 1; k >= 2; k--) {

            int i = 0;
            int j = k - 1;

            while (i < j) {

                // triangle condition
                if (nums[i] + nums[j] > nums[k]) {

                    // all pairs from i to j-1 work
                    count += (j - i);
                    j--;

                } else {
                    i++;
                }
            }
        }

        return count;
    }
}