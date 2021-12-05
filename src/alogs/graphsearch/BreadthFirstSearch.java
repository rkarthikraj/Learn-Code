package alogs.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Queue Implementation
https://www.youtube.com/watch?v=D21-XVw6nYw&t=2s
https://github.com/Anuj-Kumar-Sharma/DS-Algo/blob/master/graphs/Graph.java
 */

public class BreadthFirstSearch {
    private LinkedList<Integer> adjacent[];

    public BreadthFirstSearch(int v) {
        adjacent = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<Integer>();
        }
    }

    /* Every vertex (or node) stores a list of adjacent vertices. In an undirected graph,
    an edge like (a, b) would be stored twice: one is a's adjacent vertices and one in b's adjacent vertices. */
    public void addEdge(int source, int destination) {
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    public void printAdjacent() {
        for (LinkedList<Integer> list : adjacent) {
            System.out.println(list);
        }
    }

    public int bfs(int source, int destination) {
        boolean visited[] = new boolean[adjacent.length];
        int parent[] = new int[adjacent.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                break;
            }

            for (int neighbor : adjacent[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = current;
                }
            }
        }

        int current = destination;
        int distance = 0;

        while (parent[current] != -1) {
            System.out.print(current + " -> ");
            current = parent[current];
            distance++;
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        BreadthFirstSearch graph = new BreadthFirstSearch(vertices);
        System.out.println("Enter " + edges + " edges");

        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("----------------------------");
        graph.printAdjacent();
        System.out.println("----------------------------");

        System.out.println("Enter source and destination");
        int source = sc.nextInt();
        int destination = sc.nextInt();

        System.out.println("min distance is " + graph.bfs(source, destination));

        sc.close();
    }
}
