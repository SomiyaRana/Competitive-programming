class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        int n = colsum.length;

        int[] top = new int[n];
        int[] bottom = new int[n];

        // First fill columns having sum = 2
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                top[i] = 1;
                bottom[i] = 1;
                upper--;
                lower--;
            }
        }

        // Fill columns having sum = 1
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {

                // Put 1 where remaining count is larger
                if (upper > lower) {
                    top[i] = 1;
                    upper--;
                } else {
                    bottom[i] = 1;
                    lower--;
                }
            }
        }

        // If counts become invalid
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();

        for (int x : top) {
            row1.add(x);
        }

        for (int x : bottom) {
            row2.add(x);
        }

        ans.add(row1);
        ans.add(row2);

        return ans;
    }
}