import java.util.*;
import java.util.stream.Collectors;

public class GraphTopologySortDfs {

    public static int order;

    public static void topologySortDfs(Map<Character, List<Character>> graph) {
        Set<Character> vertexes = new HashSet<>();
        vertexes = graph.values()
                   .stream()
                   .flatMap(List::stream)
                   .collect(Collectors.toSet());
        vertexes.addAll(graph.keySet());
        order = vertexes.size();
        System.out.println("|V| = " + order);
        Set<Character> visited = new HashSet<>();

        for (Character v : graph.keySet()) {
            if (!visited.contains(v)) {
                dfs(graph, visited, v);
            }
        }
    }

    public static void dfs(Map<Character, List<Character>> graph, Set<Character> visited,
                           Character v) {
        visited.add(v);

        List<Character> adjacent = graph.getOrDefault(v, Collections.emptyList());
        for (Character w : adjacent) {
            if (!visited.contains(w)) {
                dfs(graph, visited, w);
            }
        }
        System.out.println("Vertex : " + v + " order : " + order);
        order--;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Arrays.asList('f', 'g', 'c', 'd'));
        graph.put('d', Arrays.asList('e'));
        graph.put('g', Arrays.asList('h'));
        graph.put('f', Arrays.asList('h'));
        topologySortDfs(graph);

        Map<Character, List<Character>> graph1 = new HashMap<>();
        graph1.put('s', Arrays.asList('w', 'v'));
        graph1.put('v', Arrays.asList('t'));
        graph1.put('w', Arrays.asList('t'));
        topologySortDfs(graph1);
    }
}