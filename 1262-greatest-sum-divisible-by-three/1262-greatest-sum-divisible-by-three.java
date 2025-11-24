class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // store smallest 1-rem and 2-rem numbers
        int[] r1 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] r2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int n : nums) {
            sum += n;

            if (n % 3 == 1) {
                if (n < r1[0]) {
                    r1[1] = r1[0];
                    r1[0] = n;
                } else if (n < r1[1]) {
                    r1[1] = n;
                }
            }
            else if (n % 3 == 2) {
                if (n < r2[0]) {
                    r2[1] = r2[0];
                    r2[0] = n;
                } else if (n < r2[1]) {
                    r2[1] = n;
                }
            }
        }

        if (sum % 3 == 0) return sum;

        int ans = 0;
        if (sum % 3 == 1) {
            int remove1 = r1[0];
            int remove2 = (r2[0] == Integer.MAX_VALUE || r2[1] == Integer.MAX_VALUE)
                          ? Integer.MAX_VALUE
                          : r2[0] + r2[1];
            ans = sum - Math.min(remove1, remove2);
        } 
        else { // sum % 3 == 2
            int remove1 = r2[0];
            int remove2 = (r1[0] == Integer.MAX_VALUE || r1[1] == Integer.MAX_VALUE)
                          ? Integer.MAX_VALUE
                          : r1[0] + r1[1];
            ans = sum - Math.min(remove1, remove2);
        }

        return ans < 0 ? 0 : ans;
    }
}
