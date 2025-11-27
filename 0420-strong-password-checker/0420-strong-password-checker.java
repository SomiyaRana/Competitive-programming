class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean lower = false, upper = false, digit = false;

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            else if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
        }

        int missing = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);

        int replace = 0;
        int[] len = new int[3];
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            int L = j - i;
            if (L >= 3) {
                replace += L / 3;
                len[L % 3]++;
            }
            i = j;
        }

        if (n < 6) return Math.max(6 - n, missing);

        if (n <= 20) return Math.max(replace, missing);

        int del = n - 20;

        int use = Math.min(del, len[0]);
        replace -= use;
        del -= use;

        use = Math.min(del, len[1] * 2);
        replace -= use / 2;
        del -= use;

        replace -= del / 3;

        return (n - 20) + Math.max(replace, missing);
    }
}
