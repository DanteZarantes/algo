import java.util.*;

public class ShortestPath {
    
    static String[] cities = {"Glasgow", "Stirling", "Edinburgh", "Perth", "Dundee"};
    static int[][] distances = {
        {0, 50, 70, 0, 0},
        {50, 0, 50, 40, 0},
        {70, 50, 0, 100, 0},
        {0, 40, 100, 0, 60},
        {0, 0, 0, 60, 0}
    };
    
    public static void main(String[] args) {
        int start = 2; 
        int end = 4;   
        
        int[] dist = new int[5];
        int[] previous = new int[5];
        boolean[] visited = new boolean[5];
        
        for (int i = 0; i < 5; i++) {
            dist[i] = 999999;
            previous[i] = -1;
        }
        
        dist[start] = 0;
        
        for (int count = 0; count < 5; count++) {
            int minDist = 999999;
            int u = -1;
            
            for (int i = 0; i < 5; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }
            
            if (u == -1) break;
            visited[u] = true;
            
            for (int v = 0; v < 5; v++) {
                if (distances[u][v] > 0 && !visited[v]) {
                    int newDist = dist[u] + distances[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        previous[v] = u;
                    }
                }
            }
        }
        
        System.out.println("Shortest path from Edinburgh to Dundee:");
        System.out.println("Distance: " + dist[end]);
        
        System.out.print("Path: ");
        Stack<String> path = new Stack<>();
        int current = end;
        while (current != -1) {
            path.push(cities[current]);
            current = previous[current];
        }
        
        while (!path.isEmpty()) {
            System.out.print(path.pop());
            if (!path.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }
}
