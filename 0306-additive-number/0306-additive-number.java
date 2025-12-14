class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;

            for (int j = i + 1; n - j >= Math.max(i, j - i); j++) {
                if (num.charAt(i) == '0' && j - i > 1) break;

                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));

                if (isValid(a, b, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(long a, long b, int start, String num) {
        while (start < num.length()) {
            long sum = a + b;
            String s = String.valueOf(sum);

            if (!num.startsWith(s, start)) return false;

            start += s.length();
            a = b;
            b = sum;
        }
        return true;
    }
}
