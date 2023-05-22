//-----------------------------------------------------
// Title: EdgeWeightedDigraph class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class implements an Edge Weighted Digraph algorithm.
//-----------------------------------------------------

public class EdgeWeightedDigraph {
    private final int V;                                // Number of vertices.
    private final Bag<WeightedDirectedEdge>[] adj;      // Array of bags to represent adjacency lists.

    public EdgeWeightedDigraph(int V) {                 // Constructor.
        this.V = V;                                     // Set V.
        adj = (Bag<WeightedDirectedEdge>[]) new Bag[V]; // Initialize adj list.
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<WeightedDirectedEdge>();   // Initialize each adjacency list.
        }
    }

    public void addEdge(WeightedDirectedEdge e) {       // Method to add an edge to the graph.
        int v = e.from();                               // Get the "from" vertex.
        adj[v].add(e);                                  // Add the edge to the "from" vertex's adjacency list.
    }

    public Iterable<WeightedDirectedEdge> adj(int v) {  // Returns the adjacency list of a vertex.
        return adj[v];
    }

    public int V() {                                    // Returns the number of vertices in the graph.
        return V;
    }
}
