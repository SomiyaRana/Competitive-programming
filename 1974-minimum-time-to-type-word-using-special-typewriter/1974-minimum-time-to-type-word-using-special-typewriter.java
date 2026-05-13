class Solution {
    public int minTimeToType(String word) {

        char current = 'a';
        int time = 0;

        for (char ch : word.toCharArray()) {

            int diff = Math.abs(ch - current);

            // minimum clockwise or counterclockwise moves
            time += Math.min(diff, 26 - diff);

            // typing time
            time += 1;

            current = ch;
        }

        return time;
    }
}