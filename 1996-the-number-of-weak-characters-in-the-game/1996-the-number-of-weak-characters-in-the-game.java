class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        // Sort:
        // attack -> ascending
        // defense -> descending (important)
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int weak = 0;
        int maxDefense = 0;

        // Traverse from right to left
        for (int i = properties.length - 1; i >= 0; i--) {

            int defense = properties[i][1];

            // If some right element has greater defense,
            // then it also has greater attack
            if (defense < maxDefense) {
                weak++;
            }

            maxDefense = Math.max(maxDefense, defense);
        }

        return weak;
    }
}