import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // Step 1: Convert banned array to set
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        // Step 2: Normalize paragraph (lowercase + remove punctuation)
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");
        
        // Step 3: Split into words
        String[] words = paragraph.split("\\s+");
        
        // Step 4: Count frequency
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;
        
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                
                if (map.get(word) > max) {
                    max = map.get(word);
                    result = word;
                }
            }
        }
        
        return result;
    }
}