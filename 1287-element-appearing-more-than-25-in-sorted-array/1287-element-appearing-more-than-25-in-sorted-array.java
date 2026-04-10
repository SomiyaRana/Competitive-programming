class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int step = n / 4;

        for (int i = 0; i < n - step; i++) {
            if (arr[i] == arr[i + step]) {
                return arr[i];
            }
        }

        return -1; // guaranteed to have answer, so won't reach here
    }
}