public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;

        // Step 1: Apply gravity for each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // Pointer to the rightmost empty cell
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // Move the stone to the farthest empty space
                    box[i][j] = '.';
                    box[i][empty--] = '#';
                } else if (box[i][j] == '*') {
                    // Reset the empty pointer when hitting an obstacle
                    empty = j - 1;
                }
            }
        }

        // Step 2: Rotate the box 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }
}




