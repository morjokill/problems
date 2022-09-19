import java.util.*;
import java.util.stream.Collectors;

public class KosarajuComponentDfs {
    public static int order;
    public static Integer[] topology;

    public static int kosarajuComponents(Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> reversed = reverseGraph(graph);
        Integer[] topology = topologySortDfs(reversed);
        System.out.println(Arrays.toString(topology));

        int sccNum = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer v : topology) {
            if (!visited.contains(v)) {
                basicDfs(graph, visited, v);
                sccNum++;
            }
            System.out.println("After v = " + v + " sccNum is " + sccNum + " visited: " + visited);
        }

        return sccNum;
    }

    public static void basicDfs(Map<Integer, List<Integer>> graph, Set<Integer> visited,
                           Integer v) {
        visited.add(v);

        for (Integer w : graph.get(v)) {
            if (!visited.contains(w)) {
                basicDfs(graph, visited, w);
            }
        }
    }

    public static Integer[] topologySortDfs(Map<Integer, List<Integer>> graph) {
        Set<Integer> vertexes = new HashSet<>();
        vertexes = graph.values()
                   .stream()
                   .flatMap(List::stream)
                   .collect(Collectors.toSet());
        vertexes.addAll(graph.keySet());
        order = vertexes.size();
        topology = new Integer[order];
        System.out.println("|V| = " + order);
        Set<Integer> visited = new HashSet<>();

        for (Integer v : graph.keySet()) {
            if (!visited.contains(v)) {
                topologyDfs(graph, visited, v);
            }
        }

        return topology;
    }

    public static void topologyDfs(Map<Integer, List<Integer>> graph, Set<Integer> visited,
                           Integer v) {
        visited.add(v);

        List<Integer> adjacent = graph.getOrDefault(v, Collections.emptyList());
        for (Integer w : adjacent) {
            if (!visited.contains(w)) {
                topologyDfs(graph, visited, w);
            }
        }
        System.out.println("Vertex : " + v + " order : " + order);
        topology[order - 1] = v;
        order--;
    }

    public static Map<Integer, List<Integer>> reverseGraph(Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> reversed = new HashMap<>();
        for (Integer v : graph.keySet()) {
            for (Integer w : graph.get(v)) {
                reversed.putIfAbsent(w, new LinkedList<>());
                List<Integer> cons = reversed.get(w);
                cons.add(v);
            }
        }
        return reversed;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(3));
        graph.put(3, Arrays.asList(11, 5));
        graph.put(11, Arrays.asList(6, 8));
        graph.put(6, Arrays.asList(10));
        graph.put(10, Arrays.asList(8));
        graph.put(8, Arrays.asList(6));
        graph.put(5, Arrays.asList(9, 7, 1));
        graph.put(9, Arrays.asList(8, 2, 4));
        graph.put(7, Arrays.asList(9));
        graph.put(4, Arrays.asList(7));
        graph.put(2, Arrays.asList(4, 10));
        graph.put(4, Arrays.asList(7));
        System.out.println("Number of SCC: " + kosarajuComponents(graph));
    }
}