import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        // If endGene is not in bank, no solution
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endGene)) {
                    return mutations;
                }

                char[] arr = curr.toCharArray();
                for (int pos = 0; pos < 8; pos++) {
                    char old = arr[pos];

                    for (char g : genes) {
                        if (g == old) continue;

                        arr[pos] = g;
                        String next = new String(arr);

                        if (bankSet.contains(next)) {
                            queue.offer(next);
                            bankSet.remove(next); // mark visited
                        }
                    }

                    arr[pos] = old;
                }
            }

            mutations++;
        }

        return -1;
    }
}
