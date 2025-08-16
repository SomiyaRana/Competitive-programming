class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            // A valid parentheses string must have even length.
            return false;
        }

        int open = 0; // Tracks balance for '('
        int free = 0; // Tracks flexible positions
        
        // Left-to-right pass
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') open++;
                else open--;
            } else {
                free++;
            }

            if (open + free < 0) {
                // More ')' than '(' + flexible positions
                return false;
            }
        }

        open = 0;
        free = 0;

        // Right-to-left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') open++;
                else open--;
            } else {
                free++;
            }

            if (open + free < 0) {
                // More '(' than ')' + flexible positions
                return false;
            }
        }

        return true;
    }
}
