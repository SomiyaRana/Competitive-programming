class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (num != 0 && count < 8) {
            int digit = num & 15;     // last 4 bits
            sb.append(hex[digit]);
            num >>>= 4;               // unsigned shift
            count++;
        }

        return sb.reverse().toString();
    }
}
