import java.util.Stack;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        // Create a stack to store potential starting indices
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Traverse the array and populate the stack with potential candidates for 'i'
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        
        // Step 2: Traverse from right to left to find the widest ramp
        int maxWidth = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            // As long as the current number nums[j] is >= nums[stack.peek()], calculate the width
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        
        return maxWidth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {6, 0, 8, 2, 1, 5};
        int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        
        System.out.println("Max Width Ramp (Example 1): " + solution.maxWidthRamp(nums1));  // Output: 4
        System.out.println("Max Width Ramp (Example 2): " + solution.maxWidthRamp(nums2));  // Output: 7
    }
}
