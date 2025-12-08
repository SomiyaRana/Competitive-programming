import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, count = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                count++;  // match player i with trainer j
                i++;
                j++;
            } else {
                j++;  // trainer too weak, try next one
            }
        }

        return count;
    }
}
