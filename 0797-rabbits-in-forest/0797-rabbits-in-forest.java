import java.util.*;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();    // The answer a rabbit gives
            int count = entry.getValue(); // How many rabbits gave that answer

            int groupSize = x + 1;  // Each rabbit claims there's x others, so group size is x+1
            int numberOfGroups = (count + groupSize - 1) / groupSize; // Ceiling division
            total += numberOfGroups * groupSize;
        }

        return total;
    }
}
