class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char result = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char ch = keysPressed.charAt(i);

            if (duration > maxTime || 
               (duration == maxTime && ch > result)) {
                maxTime = duration;
                result = ch;
            }
        }

        return result;
    }
}