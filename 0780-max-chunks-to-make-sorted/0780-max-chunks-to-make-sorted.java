public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {4, 3, 2, 1, 0};
        System.out.println(solution.maxChunksToSorted(arr1)); // Output: 1

        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println(solution.maxChunksToSorted(arr2)); // Output: 2
    }
}
