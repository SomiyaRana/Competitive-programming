class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];

        // count frequency
        for (int num : arr1) {
            freq[num]++;
        }

        int i = 0;

        // place elements in order of arr2
        for (int num : arr2) {
            while (freq[num]-- > 0) {
                arr1[i++] = num;
            }
        }

        // place remaining elements in ascending order
        for (int num = 0; num <= 1000; num++) {
            while (freq[num]-- > 0) {
                arr1[i++] = num;
            }
        }

        return arr1;
    }
}