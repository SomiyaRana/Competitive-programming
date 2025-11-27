class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        for (char c : arr) {
            if (isVowel(c)) vowels.add(c);
        }

        Collections.sort(vowels);
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vowels.get(idx++);
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
