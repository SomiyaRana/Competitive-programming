import java.util.Arrays;

public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistributeWithMaxX(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistributeWithMaxX(int x, int n, int[] quantities) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (int) Math.ceil((double) quantity / x);
            if (requiredStores > n) {
                return false;
            }
        }
        return requiredStores <= n;
    }
}



