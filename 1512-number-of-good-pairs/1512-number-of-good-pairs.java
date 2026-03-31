class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // since nums[i] <= 100
        int count = 0;

        for (int num : nums) {
            count += freq[num]; // existing same numbers
            freq[num]++;
        }

        return count;
    }
}