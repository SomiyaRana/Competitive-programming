import java.util.Arrays;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // sort by end ascending, and start descending if ends equal
        Arrays.sort(intervals, (x, y) -> {
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(y[0], x[0]);
        });

        int count = 0;
        // a and b are the two largest chosen points so far (a < b).
        // Initialize to very small values so they don't lie inside any real interval.
        int a = -1_000_000_000;
        int b = -1_000_000_000;

        for (int[] in : intervals) {
            int l = in[0], r = in[1];

            if (l > b) {
                // need two new points
                count += 2;
                a = r - 1;
                b = r;
            } else if (l > a) {
                // interval contains b but not a -> add one new point r
                count += 1;
                a = b;
                b = r;
            } // else interval already contains both a and b -> do nothing
        }

        return count;
    }

    // quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.intersectionSizeTwo(new int[][]{{1,3},{3,7},{8,9}})); // expected 4 (e.g. {2,3,8,9} or similar)
        System.out.println(sol.intersectionSizeTwo(new int[][]{{1,3},{1,4},{2,5},{3,5}})); // expected 3
        System.out.println(sol.intersectionSizeTwo(new int[][]{{1,2}})); // expected 2
    }
}
