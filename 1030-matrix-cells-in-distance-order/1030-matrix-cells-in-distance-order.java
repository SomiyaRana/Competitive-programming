import java.util.*;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int k = 0;

        // Step 1: store all cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[k][0] = i;
                result[k][1] = j;
                k++;
            }
        }

        // Step 2: sort by distance
        Arrays.sort(result, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return d1 - d2;
        });

        return result;
    }
}