class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int n : nums) {
            if (n % 3 != 0) ops++;
        }
        return ops;
    }
}
