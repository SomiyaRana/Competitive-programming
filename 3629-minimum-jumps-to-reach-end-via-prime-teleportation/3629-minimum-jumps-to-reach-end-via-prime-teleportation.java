import java.util.*;

class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        // Smallest Prime Factor sieve
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= maxVal; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        // prime -> indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            Set<Integer> primes = getPrimeFactors(val, spf);

            for (int p : primes) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) return steps;

                // Adjacent left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // Adjacent right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // Prime teleportation
                int val = nums[i];

                if (isPrime(val, spf) && !usedPrime.contains(val)) {

                    List<Integer> next = map.getOrDefault(val, new ArrayList<>());

                    for (int idx : next) {
                        if (!visited[idx]) {
                            visited[idx] = true;
                            q.offer(idx);
                        }
                    }

                    usedPrime.add(val);
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x, int[] spf) {
        return x > 1 && spf[x] == x;
    }

    private Set<Integer> getPrimeFactors(int x, int[] spf) {
        Set<Integer> set = new HashSet<>();

        while (x > 1) {
            set.add(spf[x]);
            x /= spf[x];
        }

        return set;
    }
}