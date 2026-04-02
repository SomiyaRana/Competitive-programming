class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];

        // count chars frequency
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        int total = 0;

        for (String word : words) {
            int[] wordCount = new int[26];
            boolean isGood = true;

            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;

                if (wordCount[c - 'a'] > charCount[c - 'a']) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                total += word.length();
            }
        }

        return total;
    }
}