import java.util.*;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Arrays.sort(nums1);

        int[][] arr = new int[n][2];

        // store nums2 value with original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }

        // sort nums2 by values
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        // assign biggest possible advantage
        for (int i = n - 1; i >= 0; i--) {

            // if nums1[right] can beat nums2 value
            if (nums1[right] > arr[i][0]) {
                ans[arr[i][1]] = nums1[right];
                right--;
            } else {
                // sacrifice smallest element
                ans[arr[i][1]] = nums1[left];
                left++;
            }
        }

        return ans;
    }
}