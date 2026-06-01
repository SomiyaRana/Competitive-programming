class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Sort tokens in ascending order to optimize the greedy approach
        Arrays.sort(tokens);
      
        // Track the maximum score achieved and current score
        int maxScore = 0;
        int currentScore = 0;
      
        // Use two pointers: left for smallest tokens, right for largest tokens
        int left = 0;
        int right = tokens.length - 1;
      
        // Process tokens while there are still tokens to consider
        while (left <= right) {
            // Case 1: If we have enough power, play the smallest token face-up
            // This gains us 1 score and costs the least power
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                currentScore++;
                // Update maximum score achieved so far
                maxScore = Math.max(maxScore, currentScore);
            }
            // Case 2: If we don't have enough power but have score,
            // play the largest token face-down to gain maximum power
            else if (currentScore > 0) {
                power += tokens[right];
                right--;
                currentScore--;
            }
            // Case 3: No power to play face-up and no score to play face-down
            // No more moves possible
            else {
                break;
            }
        }
      
        return maxScore;
    }
}
