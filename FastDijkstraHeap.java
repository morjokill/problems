import java.util.*;
import java.util.stream.*;

public class FastDijkstraHeap {
    public static Map<Character, Integer> dijkstra(Map<Character, List<Edge>> graph, Character start) {
        Map<Character, Integer> dist = new HashMap<>();
        Queue<Character> heap = new PriorityQueue<>((n1, n2) -> dist.get(n1) - dist.get(n2));

        for (Character v : graph.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        heap.addAll(graph.keySet());

        while (!heap.isEmpty()) {
            Character v = heap.poll();
            for (Edge edge : graph.get(v)) {
                Character w = edge.w;
                if (heap.remove(w)) {
                    dist.put(w, Math.min(dist.get(w), dist.get(v) + edge.weight));
                    heap.offer(w);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Map<Character, List<Edge>> graph = new HashMap<>();
        graph.put('s', Arrays.asList(edge('v', 1), edge('w', 4)));
        graph.put('v', Arrays.asList(edge('w', 2), edge('t', 6)));
        graph.put('w', Arrays.asList(edge('t', 3)));
        graph.put('t', Arrays.asList(edge('t', 0)));
        System.out.println("Dists: " + dijkstra(graph, 's'));
    }

    public static Edge edge(Character w, int weight) {
        return new Edge(w, weight);
    }

    private static class Edge {
        public Character w;
        public int weight;

        public Edge(Character w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + w + "," + weight + ")";
        }
    }
}