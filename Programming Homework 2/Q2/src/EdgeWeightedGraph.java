//-----------------------------------------------------
// Title: Farmland EdgeWeightedGraph class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class is the implementation of the EdgeWeightedGraph for the second question.
//-----------------------------------------------------
public class EdgeWeightedGraph {

    private final int V;                // Number of vertices.
    private final Bag<Edge>[] adj;      // Array of bags to store the adjacent edges for each vertex.

    public EdgeWeightedGraph(int V) {   // Constructor to create an empty graph with V vertices
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V]; // Initialize the array with bag objects.
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();   // Initialize each bag object.
        }
    }
    public int V() {                    // Method to return the number of vertices in the graph.
        return V;
    }

    public void addEdge(Edge e) {       // A method to add an edge to the graph.
        int v = e.either(), w = e.other(v); // Get the vertices of the edge.
        adj[v].add(e);                  // Add the edge to both bags.
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) { // A method to return the adjacent edges of a given vertex
        return adj[v];
    }

}