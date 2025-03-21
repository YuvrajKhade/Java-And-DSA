package dynamic_programming;

import java.util.*;

public class singleSourceShortestPath {

    public static int minDist(int[] dist, boolean[] status, int v) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < v; i++) {
            if (dist[i] < min && !status[i]) {
                min = dist[v];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int adjMat[][], int src, int V) {

        int dist[] = new int[V];
        boolean status[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            status[i] = false;
        }
        dist[src] = 0;
        for (int v = 0; v < V - 1; v++) {

            int u = minDist(dist, status, V);
            status[u] = true;

            for (int j = 0; j < V; j++) {

                if (!status[u] && dist[u] != Integer.MAX_VALUE && adjMat[u][j] != 0
                        && dist[u] + adjMat[u][v] < dist[j]) {
                    dist[j] = dist[u] + adjMat[u][v];
                }
            }
        }

        printSol(dist);

    }

    public static void printSol(int[] dist){
        System.out.println("Vertex \t\t Distance from Source");
        for(int i=0;i<dist.length;i++){
            System.out.println((i+1)+"\t\t"+dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertex");
        int v = sc.nextInt();

        int adjMat[][] = new int[v][v];
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat.length; j++) {
                adjMat[i][j] = sc.nextInt();
            }

        }

        dijkstra(adjMat, 0, v);
        sc.close();
    }
}