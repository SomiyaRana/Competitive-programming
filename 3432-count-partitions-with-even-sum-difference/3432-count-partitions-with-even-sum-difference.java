class Solution {
    public int countPartitions(int[] nums) {
        int total = 0, count = 0;
        for (int x : nums) total += x;

        int leftSum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int rightSum = total - leftSum;

            if ((leftSum % 2) == (rightSum % 2))  
                count++;
        }

        return count;
    }
}
