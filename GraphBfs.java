import java.util.*;

public class GraphBfs {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(3, Arrays.asList(5, 6));
        graph.put(4, Arrays.asList(7));
        graph.put(5, Arrays.asList(7));
        graph.put(2, Arrays.asList(8));
        graph.put(8, Arrays.asList(9));
        graph.put(9, Arrays.asList(7));

        System.out.println(graph);
        System.out.println(minPath(graph, 1, 7));
    }

    private static int minPath(Map<Integer, List<Integer>> graph,
                               int start, int end) {
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int level = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                int node = queue.pop();
                System.out.println("level: " + level + " current node: " + node);

                if (!visited.contains(node)) {
                    if (node == end) return level;
                    List<Integer> neighbours = graph.get(node);
                    if (neighbours != null) queue.addAll(neighbours);
                    visited.add(node);
                }
                levelSize--;
            }
            level++;
        }

        return -1;
    }
}