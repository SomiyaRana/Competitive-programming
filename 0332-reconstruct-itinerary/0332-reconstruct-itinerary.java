import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Step 1: Build graph
        for (List<String> ticket : tickets) {
            graph
                .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .add(ticket.get(1));
        }

        // Step 2: DFS
        dfs("JFK");

        // Step 3: Reverse result
        Collections.reverse(result);
        return result;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = graph.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // always smallest lexical
        }

        result.add(src); // post-order
    }
}