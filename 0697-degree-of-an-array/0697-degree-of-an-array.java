import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        
        int degree = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            firstIndex.putIfAbsent(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
            
            int freq = count.get(num);
            
            if (freq > degree) {
                degree = freq;
                minLength = i - firstIndex.get(num) + 1;
            } else if (freq == degree) {
                minLength = Math.min(minLength, i - firstIndex.get(num) + 1);
            }
        }
        
        return minLength;
    }
}