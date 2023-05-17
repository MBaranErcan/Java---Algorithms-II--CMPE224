//-----------------------------------------------------
// Title: DijkstraSP class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 3
// Description: This class implements the Dijkstra Shortest Path algorithm.
//-----------------------------------------------------

import java.util.*;

public class DijkstraSP {
    private WeightedDirectedEdge[] edgeTo;                      // Array to keep track of edges.
    private int[] distTo;                                       // Array to keep track of distances
    private PriorityQueue<WeightedDirectedEdge> pq;             // PQ to keep track of vertices to visit.

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new WeightedDirectedEdge[G.V()];               // Initializes the edgeTo array.
        distTo = new int[G.V()];                                // Initializes the distTo array.
        pq = new PriorityQueue<WeightedDirectedEdge>(G.V());    // Initializes the priority queue.

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Integer.MAX_VALUE;                      // Set all distances to MAX_VALUE, so when comparison is made they will be for sure bigger than the newer path.
        }
        distTo[s] = 0;                                          // Set distance to source vertex to 0.

        pq.add(new WeightedDirectedEdge(s,s,0));        // Add source vertex to the PQ.
        while (!pq.isEmpty()) {                                 // While the PQ is not empty:
            WeightedDirectedEdge e = pq.poll();                 // Get the vertex with the smallest distance,
            int v = e.to();                                     // Get the vertex which is being visited,
            for (WeightedDirectedEdge edge : G.adj(v))          // And relax every edge.
                relax(edge);
        }
    }

    private void relax(WeightedDirectedEdge e) {                // Method to relax an edge. It takes an edge as an input.
        int v = e.from(), w = e.to();                           // Get vertices connecting by that edge.
        if (distTo[w] > distTo[v] + e.weight()) {               // If the distance to w is greater than the distance to v + the weight of edge;
            distTo[w] = distTo[v] + e.weight();                 // Update distance to w.
            edgeTo[w] = e;                                      // Update edgeTo.
            pq.add(e);                                          // Add w to the PQ.
        }
    }

    public int distTo(int v) {                                  // Returns the distance to vertex v.
        return distTo[v];
    }
}

