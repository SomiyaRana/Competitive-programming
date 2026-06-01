class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Check if total cards can be evenly divided into groups
        if (hand.length % groupSize != 0) {
            return false;
        }
      
        // Sort the hand array to process cards in ascending order
        Arrays.sort(hand);
      
        // Create frequency map to count occurrences of each card value
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int cardValue : hand) {
            frequencyMap.merge(cardValue, 1, Integer::sum);
        }
      
        // Try to form consecutive groups starting from each card
        for (int startCard : hand) {
            // Only process if this card is still available
            if (frequencyMap.getOrDefault(startCard, 0) > 0) {
                // Try to form a group of consecutive cards starting from startCard
                for (int currentCard = startCard; currentCard < startCard + groupSize; currentCard++) {
                    // Decrement the count for current card and check if it becomes negative
                    if (frequencyMap.merge(currentCard, -1, Integer::sum) < 0) {
                        // Not enough cards to form a valid group
                        return false;
                    }
                }
            }
        }
      
        // All cards successfully grouped
        return true;
    }
}