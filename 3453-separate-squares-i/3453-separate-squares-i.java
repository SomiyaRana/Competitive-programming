class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        for (int i = 0; i < 60; i++) { // enough for 1e-5 precision
            double mid = (low + high) / 2;
            double diff = areaDiff(squares, mid);

            if (diff > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }

    private double areaDiff(int[][] squares, double y) {
        double above = 0, below = 0;

        for (int[] s : squares) {
            double bottom = s[1];
            double top = s[1] + s[2];
            double len = s[2];

            if (top <= y) {
                below += len * len;
            } else if (bottom >= y) {
                above += len * len;
            } else {
                below += (y - bottom) * len;
                above += (top - y) * len;
            }
        }

        return above - below;
    }
}
