class Solution {
    // Store all unique subsets
    private List<List<Integer>> result = new ArrayList<>();
    // Store current subset being built
    private List<Integer> currentSubset = new ArrayList<>();
    // Input array
    private int[] nums;

    /**
     * Find all possible subsets of the given array, excluding duplicates.
     * @param nums - input array that may contain duplicate elements
     * @return list of all unique subsets
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort array to group duplicate elements together
        Arrays.sort(nums);
        this.nums = nums;
        // Start backtracking from index 0
        backtrack(0);
        return result;
    }

    /**
     * Backtracking helper method to generate all unique subsets.
     * @param index - current position in the nums array
     */
    private void backtrack(int index) {
        // Base case: reached end of array, add current subset to result
        if (index >= nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
      
        // Include current element in subset
        currentSubset.add(nums[index]);
        backtrack(index + 1);
      
        // Backtrack: remove the element we just added
        int removedElement = currentSubset.remove(currentSubset.size() - 1);
      
        // Skip all duplicate occurrences of the removed element
        // This ensures we don't create duplicate subsets
        while (index + 1 < nums.length && nums[index + 1] == removedElement) {
            index++;
        }
      
        // Explore subsets without including the current element (and its duplicates)
        backtrack(index + 1);
    }
}