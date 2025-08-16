import java.util.*;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Create a max-heap to store characters by their lexicographical order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int currentFreq = freq[current - 'a'];
            int useCount = Math.min(currentFreq, repeatLimit);

            // Append the current character up to the limit
            for (int i = 0; i < useCount; i++) {
                result.append(current);
            }
            freq[current - 'a'] -= useCount;

            // If there's still frequency left for the current character
            if (freq[current - 'a'] > 0) {
                // Check if there is another character to insert in between
                if (!maxHeap.isEmpty()) {
                    char next = maxHeap.poll();
                    result.append(next); // Append the next character
                    freq[next - 'a']--;

                    // Reinsert the next character if it still has remaining frequency
                    if (freq[next - 'a'] > 0) {
                        maxHeap.offer(next);
                    }

                    // Reinsert the current character back into the heap
                    maxHeap.offer(current);
                } else {
                    // No other character to insert, stop the process
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cczazcc";
        int repeatLimit = 2;
        System.out.println(solution.repeatLimitedString(s, repeatLimit)); // Output: "zzccac"
    }
}
