class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = 1000000007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1]; 

        dp[0] = 1;              
        prefix[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right])
                minQ.pollLast();
            minQ.offerLast(right);

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right])
                maxQ.pollLast();
            maxQ.offerLast(right);

            
            while (!minQ.isEmpty() && !maxQ.isEmpty() &&
                   nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {

                if (minQ.peekFirst() == left) minQ.pollFirst();
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                left++;
            }

            dp[right + 1] = (prefix[right] - (left > 0 ? prefix[left - 1] : 0) + mod) % mod;

            prefix[right + 1] = (prefix[right] + dp[right + 1]) % mod;
        }

        return (int) dp[n];
    }
}
