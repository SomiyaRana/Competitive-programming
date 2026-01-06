class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] need = new int[26];

        // Count required letters from licensePlate
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                need[Character.toLowerCase(ch) - 'a']++;
            }
        }

        String answer = null;

        for (String word : words) {
            if (isCompleting(word, need)) {
                if (answer == null || word.length() < answer.length()) {
                    answer = word;
                }
            }
        }

        return answer;
    }

    private boolean isCompleting(String word, int[] need) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < need[i]) {
                return false;
            }
        }

        return true;
    }
}
