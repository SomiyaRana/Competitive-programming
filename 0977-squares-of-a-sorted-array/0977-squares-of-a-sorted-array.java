class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0, right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                res[index--] = leftSq;
                left++;
            } else {
                res[index--] = rightSq;
                right--;
            }
        }

        return res;
    }
}