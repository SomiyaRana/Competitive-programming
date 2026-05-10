class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        
        // Single character palindrome cannot be broken
        if (n == 1) {
            return "";
        }
        
        char[] arr = palindrome.toCharArray();
        
        // Change first non-'a' character in first half to 'a'
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        
        // If all are 'a', change last character to 'b'
        arr[n - 1] = 'b';
        
        return new String(arr);
    }
}