import java.util.*;

public class GraphTraversal {
    
    static char[][] graph = {
        {'A', 'C', 'B', 'D'},
        {'B', 'A', 'C', 'E', 'G'},
        {'C', 'A', 'B', 'D'},
        {'D', 'C', 'A'},
        {'E', 'G', 'F', 'B'},
        {'F', 'G', 'E'},
        {'G', 'F', 'B'}
    };
    
    static boolean[] visited = new boolean[7];
    static char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    
    public static void main(String[] args) {
        System.out.println("DFS from A:");
        dfs('A');
        System.out.println();
        
        System.out.println("\nBFS from A:");
        bfs('A');
    }
    
    static void dfs(char node) {
        System.out.print(node + " ");
        visited[getIndex(node)] = true;
        
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == node) {
                for (int j = 1; j < graph[i].length; j++) {
                    char neighbor = graph[i][j];
                    if (!visited[getIndex(neighbor)]) {
                        dfs(neighbor);
                    }
                }
            }
        }
    }
    
    static void bfs(char start) {
        boolean[] seen = new boolean[7];
        Queue<Character> queue = new LinkedList<>();
        
        queue.add(start);
        seen[getIndex(start)] = true;
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + " ");
            
            for (int i = 0; i < graph.length; i++) {
                if (graph[i][0] == current) {
                    for (int j = 1; j < graph[i].length; j++) {
                        char neighbor = graph[i][j];
                        if (!seen[getIndex(neighbor)]) {
                            seen[getIndex(neighbor)] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
    }
    
    static int getIndex(char node) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == node) return i;
        }
        return -1;
    }
}
