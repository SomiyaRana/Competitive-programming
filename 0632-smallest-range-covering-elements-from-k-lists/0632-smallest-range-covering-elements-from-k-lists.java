import java.util.*;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        
        // Initialize the priority queue with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            pq.offer(new Element(value, i, 0));
            max = Math.max(max, value);
        }
        
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        while (pq.size() == nums.size()) {
            Element curr = pq.poll();
            int min = curr.value;
            
            // Update the range if it's smaller
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }
            
            // Get the next element from the same list, if available
            if (curr.idx + 1 < nums.get(curr.listIdx).size()) {
                int nextValue = nums.get(curr.listIdx).get(curr.idx + 1);
                pq.offer(new Element(nextValue, curr.listIdx, curr.idx + 1));
                max = Math.max(max, nextValue);
            }
        }
        
        return new int[] {rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        Solution sr = new Solution();
        List<List<Integer>> nums1 = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );
        System.out.println(Arrays.toString(sr.smallestRange(nums1))); // Output: [20, 24]

        List<List<Integer>> nums2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        System.out.println(Arrays.toString(sr.smallestRange(nums2))); // Output: [1, 1]
    }

    static class Element {
        int value;
        int listIdx;
        int idx;

        Element(int value, int listIdx, int idx) {
            this.value = value;
            this.listIdx = listIdx;
            this.idx = idx;
        }
    }
}
