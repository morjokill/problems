import java.util.*;
import java.util.stream.*;

public class SlowDijkstra {
    public static Map<Character, Integer> dijkstra(List<Edge> graph, Character start) {
        Set<Character> visited = new HashSet<>();
        Map<Character, Integer> dist = new HashMap<>();

        dist.put(start, 0);
        visited.add(start);

        Edge minEdge;
        do {
            minEdge = null;
            for (Edge edge : graph) {
                if (visited.contains(edge.v)
                        && !visited.contains(edge.w)
                        && (minEdge == null || edge.weight < minEdge.weight)) {
                    minEdge = edge;
                }
            }
            if (minEdge != null) {
                visited.add(minEdge.w);
                dist.put(minEdge.w, dist.get(minEdge.v) + minEdge.weight);
            }
        } while (minEdge != null);
        return dist;
    }

    public static void main(String[] args) {
        // page 117
        List<Edge> graph = new ArrayList<>();
        graph.add(edge('s', 'v', 1));
        graph.add(edge('s', 'w', 4));
        graph.add(edge('v', 'w', 2));
        graph.add(edge('v', 't', 6));
        graph.add(edge('w', 't', 3));
        graph.add(edge('t', 't', 0));
        System.out.println("Dists: " + dijkstra(graph, 's'));
    }

    public static Edge edge(Character v, Character w, int weight) {
        return new Edge(v, w, weight);
    }

    private static class Edge {
        public Character v;
        public Character w;
        public int weight;

        public Edge(Character v, Character w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + v + " --> " + w + "," + weight + ")";
        }
    }
}