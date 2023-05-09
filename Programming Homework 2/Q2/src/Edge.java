//-----------------------------------------------------
// Title: Farmland Edge class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class is the implementation of the Edge Object for the second question.
//-----------------------------------------------------
public class Edge implements Comparable<Edge> {
    private final int v;            // The first vertex of the edge.
    private final int w;            // The second vertex of the edge.
    private int visitedCount;       // The number of times the edge is visited in the MST.
    private final double weight;    // The weight of the edge.

    public Edge(int v, int w, double weight) { // Constructor to create an edge with given vertices and weight
        this.v = v;
        this.w = w;
        visitedCount = 1;                       // Initialize the visited count to 1. So we can calculate MST weight with the formula in the question.
        this.weight = weight;
    }

    public int either() {                       // A method to return either vertex of the edge.
        return v;
    }

    public int other(int vertex) {              // A method to return the other vertex of the edge given one vertex.
        if (vertex == v) {
            return w;
        } else
            return v;
    }

    public void visit() {                       // A method to increment the visited count of the edge.
        visitedCount++;
    }

    public int getVisitedCount() {              // A method to return the visited count of the edge.
        return visitedCount;
    }

    public double weight() {                    // A method to return the weight of the edge
        return weight;
    }

    public int compareTo(Edge other) {          // A method to compare two edges by their weights
        return Double.compare(this.weight, other.weight);
    }
}