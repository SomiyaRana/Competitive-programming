import java.util.*;

class Solution {

    private int maxConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);
        int max = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
}
