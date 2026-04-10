import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: check uniqueness using a set
        Set<Integer> set = new HashSet<>();
        
        for (int freq : freqMap.values()) {
            if (!set.add(freq)) {
                return false; // duplicate frequency found
            }
        }
        
        return true;
    }
}