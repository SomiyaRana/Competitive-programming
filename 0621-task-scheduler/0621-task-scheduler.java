class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // count frequency
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // count tasks having max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // formula
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maxFreq * maxCount);
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}