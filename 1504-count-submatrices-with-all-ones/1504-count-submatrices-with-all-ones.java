class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) height[j] += 1;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                int minHeight = height[j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, height[k]);
                    ans += minHeight;
                }
            }
        }
        return ans;
    }
}
