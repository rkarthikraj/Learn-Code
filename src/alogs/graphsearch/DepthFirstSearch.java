package alogs.graphsearch;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
Stack Implementation
https://www.youtube.com/watch?v=D21-XVw6nYw&t=2s
https://github.com/Anuj-Kumar-Sharma/DS-Algo/blob/master/graphs/Graph.java
 */
public class DepthFirstSearch {
    private LinkedList<Integer> adjacent[];

    public DepthFirstSearch(int v) {
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

    public boolean dfsStack(int source, int destination) {
        boolean visited[] = new boolean[adjacent.length];
        visited[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == destination) {
                return true;
            }

            for (int neighbor : adjacent[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        DepthFirstSearch graph = new DepthFirstSearch(vertices);
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

        System.out.println("Is path exist " + graph.dfsStack(source, destination));

        sc.close();
    }
}
