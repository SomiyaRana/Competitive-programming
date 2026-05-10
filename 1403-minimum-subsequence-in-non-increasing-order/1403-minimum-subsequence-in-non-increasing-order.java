import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        // Sort in ascending order
        Arrays.sort(nums);
        
        int currSum = 0;
        
        // Pick largest elements first
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            ans.add(nums[i]);
            
            if (currSum > totalSum - currSum) {
                break;
            }
        }
        
        return ans;
    }
}