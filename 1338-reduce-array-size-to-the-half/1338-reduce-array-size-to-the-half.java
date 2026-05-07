class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Store frequencies
        List<Integer> freq = new ArrayList<>(map.values());

        // Sort in descending order
        freq.sort(Collections.reverseOrder());

        int removed = 0;
        int count = 0;
        int half = arr.length / 2;

        // Greedily remove highest frequencies first
        for (int f : freq) {
            removed += f;
            count++;

            if (removed >= half) {
                return count;
            }
        }

        return count;
    }
}