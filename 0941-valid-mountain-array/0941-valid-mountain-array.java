class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // Step 1: climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Step 2: peak check
        if (i == 0 || i == n - 1) return false;

        // Step 3: go down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Step 4: must reach end
        return i == n - 1;
    }
}