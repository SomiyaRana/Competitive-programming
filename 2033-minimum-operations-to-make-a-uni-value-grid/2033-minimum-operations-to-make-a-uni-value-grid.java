import java.util.Arrays;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        int index = 0;
        int remainder = grid[0][0] % x;

        // Flatten the grid and check if transformation is possible
        for (int[] row : grid) {
            for (int num : row) {
                if (num % x != remainder) {
                    return -1; // Transformation is not possible
                }
                arr[index++] = num;
            }
        }

        // Sort the array to find the median
        Arrays.sort(arr);
        int median = arr[size / 2];
        int operations = 0;

        // Calculate the total number of operations required
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
