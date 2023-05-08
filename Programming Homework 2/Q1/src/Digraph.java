//-----------------------------------------------------
// Title: Uber Company Digraph class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class implements the Digraph class for the first question.
//-----------------------------------------------------
public class Digraph {
    private final int V;                // The number of vertices in the graph.
    private int E;                      // The number of edges in the graph.
    private final Bag<District>[] adj;  // Array of bags to represent the adjacency list.

    public Digraph(int V){              // Constructor to create Digraph with V vertices.
        this.V = V;
        adj = (Bag<District>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<District>();
    }

    public int V() { return V;}         // Method to return the V value. We don't use it though.

    public void addEdge(District v, District w) {   // Method to add an edge between two vertices (from v, to w) in the graph.
        adj[v.getId()].add(w);
        E++;
    }

    public Iterable<District> adj(District v) { // Iterator for vertices pointing from v.
        return adj[v.getId()];
    }

    public boolean checkIfTree(){                                           // Method to check if the graph can be represented as a tree.
        return Is_E_V_minus1() && is_StronglyConnected() && !hasCycle();    // In order for graph to be represented as a tree: Is_E_V_minus1() and is_StronglyConnected() should be TRUE,
    }                                                                       // and hasCycle() should be FALSE.

    public boolean Is_E_V_minus1(){             // Method to check if the graph has n-1 edges.
        return E == V - 1;
    }

    public boolean is_StronglyConnected() {     // Method to check if the graph is strongly connected.
        boolean[] visited = new boolean[V];     // Boolean array to keep track of visited vertices.
        dfs(0, visited);                     // Perform a DFS from an arbitrary vertex.
        for (int i = 0; i < V; i++) {           // Loop through all vertices in the graph.
            if (!visited[i]) {                  // If a vertex has not been visited, the graph is not strongly connected.
                return false;
            }
        }
        return true;
    }

    private void dfs(int v, boolean[] visited) {    // Method to perform a Depth-First Search on the graph.
        visited[v] = true;                          // We use dfs to check if the graph is strongly connected.
        for (District w : adj[v]) {
            if (!visited[w.getId()]) {
                dfs(w.getId(), visited);
            }
        }
    }

    public boolean hasCycle() {             // Method to check if the graph has a cycle.
        if (E < 2) return false;            // Logically, if there are less than 2 edges, there cannot be a cycle.
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!adj[i].isEmpty() && hasCycleUtil(adj[i].iterator().next(), visited, recStack))
                return true;                // If the vertex has not been visited and has a cycle, return True
        }
        return false;                       // If no cycles are found, return False
    }

    private boolean hasCycleUtil(District v, boolean[] visited, boolean[] recStack) { // Method to check if the graph has a cycle using recursion.
        visited[v.getId()] = true;          // Mark the current vertex as visited.
        recStack[v.getId()] = true;         // Add the current vertex to the recursion stack.
        for (District w : adj(v)) {         // Loop through all vertices that are adjacent to the current vertex.
            if (!visited[w.getId()] && hasCycleUtil(w, visited, recStack)) {
                return true;                // If the adjacent vertex has not been visited and has a cycle, return True.
            } else if (recStack[w.getId()]) {
                return true;                // If it is already in the recursion Stack, return True.
            }
        }
        recStack[v.getId()] = false;        // Remove the current vertex from stack.
        return false;                       // If no cycles are found, return false
    }
}
