class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        long sum = 0, squareSum = 0;
        for (int num : nums) {
            sum += num;
            squareSum += (long) num * num;
        }
        
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        long diff = sum - expectedSum; // x - y
        long squareDiff = squareSum - expectedSquareSum; // x^2 - y^2
        
        long sumXY = squareDiff / diff; // x + y
        
        int x = (int) ((diff + sumXY) / 2); // duplicate
        int y = (int) (sumXY - x); // missing
        
        return new int[]{x, y};
    }
}