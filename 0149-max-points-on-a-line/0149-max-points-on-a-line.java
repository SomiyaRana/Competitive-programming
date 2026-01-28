import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                if (dx == 0) {          // vertical line
                    dy = 1;
                } else if (dy == 0) {   // horizontal line
                    dx = 1;
                } else {
                    if (dx < 0) {  // normalize sign
                        dx = -dx;
                        dy = -dy;
                    }
                    int g = gcd(Math.abs(dy), Math.abs(dx));
                    dy /= g;
                    dx /= g;
                }

                String key = dy + "/" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }

            ans = Math.max(ans, max + 1); // include point i
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
