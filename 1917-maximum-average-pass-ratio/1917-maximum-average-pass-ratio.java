import java.util.PriorityQueue;

public class Solution {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to maximize the impact of adding a student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0])); // Compare based on gain

        // Initialize the heap with the gain for each class
        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            maxHeap.offer(new double[]{calculateGain(pass, total), pass, total});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        for (double[] entry : maxHeap) {
            totalRatio += entry[1] / entry[2]; // pass / total
        }

        return totalRatio / classes.length;
    }

    private static double calculateGain(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.println("Test 1: " + maxAverageRatio(classes1, extraStudents1)); // Expected: 0.78333

        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}};
        int extraStudents2 = 3;
        System.out.println("Test 2: " + maxAverageRatio(classes2, extraStudents2)); // Expected: 0.618056
    }
}
