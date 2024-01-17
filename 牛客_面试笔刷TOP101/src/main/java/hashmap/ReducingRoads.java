package hashmap;

import java.util.*;

/**
 * 第三题
 */
public class ReducingRoads {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        long[] distances = dijkstra(1, graph, n);

        int roadsNotNeeded = 0;
        for (int i = 0; i < k; i++) {
            int p = scanner.nextInt();
            int s = scanner.nextInt();
            if (distances[p] <= s) {
                roadsNotNeeded++;
            }
        }

        System.out.println(roadsNotNeeded);
    }

    private static long[] dijkstra(int start, List<List<Edge>> graph, int n) {
        long[] distances = new long[n + 1];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (distances[current.to] < current.weight) continue;

            for (Edge edge : graph.get(current.to)) {
                long newDist = distances[current.to] + edge.weight;
                if (newDist < distances[edge.to]) {
                    distances[edge.to] = newDist;
                    pq.add(new Edge(edge.to, (int) newDist));
                }
            }
        }

        return distances;
    }
}
