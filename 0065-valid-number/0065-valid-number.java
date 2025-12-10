class Solution {
    public boolean isNumber(String s) {
        s = s.trim();        
        
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenExp) digitAfterExp = true;
            }
            else if (c == '+' || c == '-') {
                // sign valid only at beginning or just after exponent
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                    return false;
            }
            else if (c == '.') {
                // dot can't appear twice or after exponent
                if (seenDot || seenExp) return false;
                seenDot = true;
            }
            else if (c == 'e' || c == 'E') {
                if (!seenDigit || seenExp) return false;
                seenExp = true;
                digitAfterExp = false; 
            }
            else return false; 
        }

        return seenDigit && digitAfterExp;
    }
}
