class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];

        // Step 1: Count frequency
        for (int card : deck) {
            count[card]++;
        }

        // Step 2: Find GCD of all counts
        int gcd = 0;
        for (int c : count) {
            if (c > 0) {
                gcd = gcd == 0 ? c : getGCD(gcd, c);
            }
        }

        // Step 3: Check condition
        return gcd >= 2;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}