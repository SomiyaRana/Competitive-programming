import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {

        // Sort events by start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Min-heap to store end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 1;
        int i = 0;
        int n = events.length;
        int attended = 0;

        while (i < n || !minHeap.isEmpty()) {

            // If no active events, jump to next event's start day
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting today
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            }
        }

        return attended;
    }
}