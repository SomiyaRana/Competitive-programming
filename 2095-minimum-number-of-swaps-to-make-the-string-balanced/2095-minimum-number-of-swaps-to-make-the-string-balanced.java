public class Solution {
    public int minSwaps(String s) {
        int imbalance = 0, maxImbalance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance++;
            } else {
                imbalance--;
            }
            maxImbalance = Math.max(maxImbalance, -imbalance);
        }
        
        return (maxImbalance + 1) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.minSwaps("][]["));
        System.out.println(solution.minSwaps("]]][[[")); 
        System.out.println(solution.minSwaps("[]")); 
    }
}

