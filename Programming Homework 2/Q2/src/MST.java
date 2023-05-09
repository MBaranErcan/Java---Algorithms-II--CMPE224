//-----------------------------------------------------
// Title: Farmland MST class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class is the implementation of the MST (Prim's algorithm) for the second question.
//-----------------------------------------------------
import java.util.*;

public class MST {
    private boolean[] marked;                               // Array to mark the visited vertices in the MST.
    private Queue<Edge> mst;                                // Queue to store the edges in the MST.
    private PriorityQueue<Edge> pq;                         // MinPQ to store the edges.

    public MST(EdgeWeightedGraph G ,int startingIndex) {    // Constructor to create a MST with given graph and starting vertex.
        pq = new PriorityQueue<>();                         // Initialize the PQ, the queue and the marked array.
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        visit(G, startingIndex);                            // Visit the starting vertex and add its adjacent edges to the PQ.

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {   // Loop until the PQ is empty or the MST has V-1 edges.
            Edge e = pq.remove();                           // Delete the min weighted edge.
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;           // If both endpoints are in the MST ignore it.
            mst.add(e);
            if (!marked[v]) visit(G, v);                    // Visit v and add its adjacent edges to the PQ.
            if (!marked[w]) visit(G, w);                    // Visit w and add its adjacent edges to the PQ.
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {        // Method to visit a vertex and add its adjacent edges to the PQ.
        marked[v] = true;                                   // Mark the vertex as visited.
        for (Edge e : G.adj(v)) {                           // Iterate over the adjacent edges.
            if (!marked[e.other(v)]) {                      // If the other vertex of the edge is not visited, add it to PQ.
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {                         // Method to return the edges in the MST
        return mst;
    }

    public int weight() {                                   // Method to return the weight of the MST
        int weight = 0;
        for (Edge e : mst) {                                // For each edge in the MST,
            weight += (e.weight() * Math.ceil(e.getVisitedCount() / 2.0)); // calculate the weight by the given formula.
            e.visit();                                      // Increment the visited count of that edge.
        }
        return weight;                                      // Return the weight value.
    }

}