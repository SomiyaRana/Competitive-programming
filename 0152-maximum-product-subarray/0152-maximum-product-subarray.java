class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            // Store previous max because we'll update it
            int tempMax = maxProd;
            
            maxProd = Math.max(num, Math.max(maxProd * num, minProd * num));
            minProd = Math.min(num, Math.min(tempMax * num, minProd * num));
            
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}
