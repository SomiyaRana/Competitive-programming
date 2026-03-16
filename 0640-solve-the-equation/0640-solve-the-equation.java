class Solution {
    public String solveEquation(String equation) {
        String[] sides = equation.split("=");

        int[] left = parse(sides[0]);
        int[] right = parse(sides[1]);

        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (coeff == 0) {
            if (constant == 0) return "Infinite solutions";
            return "No solution";
        }

        return "x=" + (constant / coeff);
    }

    private int[] parse(String s) {
        int coeff = 0, constant = 0;
        int sign = 1, num = 0;
        boolean hasNum = false;

        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                hasNum = true;
            } else if (i < s.length() && s.charAt(i) == 'x') {
                coeff += sign * (hasNum ? num : 1);
                num = 0;
                hasNum = false;
            } else {
                constant += sign * num;
                num = 0;
                hasNum = false;

                if (i < s.length())
                    sign = (s.charAt(i) == '-') ? -1 : 1;
            }
        }

        return new int[]{coeff, constant};
    }
}