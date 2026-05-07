class Solution {

    public int minimumSwap(String s1, String s2) {

        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {

            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (a == 'x' && b == 'y') {
                xy++;
            }
            else if (a == 'y' && b == 'x') {
                yx++;
            }
        }

        // Impossible
        if ((xy + yx) % 2 == 1) {
            return -1;
        }

        int ans = 0;

        // Pairs of same mismatches
        ans += xy / 2;
        ans += yx / 2;

        // One leftover xy and one leftover yx
        if (xy % 2 == 1) {
            ans += 2;
        }

        return ans;
    }
}