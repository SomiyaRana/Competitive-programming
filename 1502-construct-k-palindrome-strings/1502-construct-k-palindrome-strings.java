import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false; // Not enough characters to form k palindromes
        }

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : freqMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
