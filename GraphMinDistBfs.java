import java.util.*;
import javafx.util.Pair;

public class GraphMinDistBfs {
    public static void minDistBfs(Map<Character, List<Character>> graph, Character start) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> levels = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        levels.put(start, 0);
        queue.offer(start);
        visited.add(start);

        int level = 0;
        while (queue.size() != 0) {
            Character v = queue.poll();
            if (level != levels.get(v)) {
                level = levels.get(v);
                System.out.println();
            }
            System.out.print(v + "    ");

            for (Character w : graph.getOrDefault(v, Collections.emptyList())) {
                if (!visited.contains(w)) {
                    levels.put(w, levels.get(v) + 1);
                    queue.offer(w);
                    visited.add(w);
                }
            }
        }

        System.out.println();
        System.out.println(levels);
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Arrays.asList('c', 'd', 'f', 'g'));
        graph.put('d', Arrays.asList('e'));
        minDistBfs(graph, 'a');
    }
}