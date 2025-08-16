public class Solution {
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        
        // Store the last position of each digit
        for (int i = 0; i < numArray.length; i++) {
            last[numArray[i] - '0'] = i;
        }
        
        // Try to find the first position where a swap can increase the number
        for (int i = 0; i < numArray.length; i++) {
            for (int d = 9; d > numArray[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = numArray[i];
                    numArray[i] = numArray[last[d]];
                    numArray[last[d]] = temp;
                    return Integer.parseInt(new String(numArray));
                }
            }
        }
        
        return num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumSwap(2736)); // Output: 7236
        System.out.println(sol.maximumSwap(9973)); // Output: 9973
    }
}
