class Solution {
    public int numRookCaptures(char[][] board) {
        int r = 0, c = 0;

        // Find rook position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                }
            }
        }

        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // Explore all 4 directions
        for (int[] d : dirs) {
            int x = r + d[0];
            int y = c + d[1];

            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == 'B') break; // blocked
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }
                x += d[0];
                y += d[1];
            }
        }

        return count;
    }
}