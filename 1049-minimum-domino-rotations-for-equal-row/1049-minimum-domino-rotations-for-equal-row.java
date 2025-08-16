public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1 || tops[0] == bottoms[0]) return result;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            // If the target doesn't exist on either side, it's impossible
            if (tops[i] != target && bottoms[i] != target) return -1;
            else if (tops[i] != target) rotateTop++;     // rotate top to get target
            else if (bottoms[i] != target) rotateBottom++; // rotate bottom to get target
        }

        return Math.min(rotateTop, rotateBottom);
    }
}
