class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        
        // frequency count
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : barcodes) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );
        
        for (int key : freq.keySet()) {
            pq.offer(new int[]{key, freq.get(key)});
        }
        
        int[] ans = new int[n];
        int idx = 0;
        
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            
            ans[idx++] = first[0];
            ans[idx++] = second[0];
            
            first[1]--;
            second[1]--;
            
            if (first[1] > 0) {
                pq.offer(first);
            }
            
            if (second[1] > 0) {
                pq.offer(second);
            }
        }
        
        // remaining element
        if (!pq.isEmpty()) {
            ans[idx] = pq.poll()[0];
        }
        
        return ans;
    }
}