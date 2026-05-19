import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;

        // Store jobs as {difficulty, profit}
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort workers
        Arrays.sort(worker);

        int totalProfit = 0;
        int bestProfit = 0;
        int j = 0;

        // Assign best possible job to each worker
        for (int ability : worker) {

            while (j < n && jobs[j][0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs[j][1]);
                j++;
            }

            totalProfit += bestProfit;
        }

        return totalProfit;
    }
}