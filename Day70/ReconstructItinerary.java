import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Build graph
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, result);
        }
        
        result.add(airport);
    }
}