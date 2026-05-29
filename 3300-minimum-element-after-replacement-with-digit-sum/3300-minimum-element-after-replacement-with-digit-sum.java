class Solution {
    
    // Function to find digit sum
    public int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, digitSum(num));
        }

        return min;
    }
}