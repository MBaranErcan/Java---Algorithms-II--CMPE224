//-----------------------------------------------------
// Title: WeightedDirectedEdge class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class implements the Weighted Directed Edge Object.
//-----------------------------------------------------

public class WeightedDirectedEdge implements Comparable<WeightedDirectedEdge> {
    private final int v;                                    // The source vertex of the edge.
    private final int w;                                    // The destination vertex of the edge.
    private final int weight;                               // The weight of the edge.

    public WeightedDirectedEdge(int v, int w, int weight) { // Constructor that takes the
        this.v = v;                                         // Source vertex,
        this.w = w;                                         // Destination vertex,
        this.weight = weight;                               // And weight as input.
    }

    public int from() {                                     // Returns the source vertex of the edge.
        return v;
    }

    public int to() {                                       // Returns the destination vertex of the edge.
        return w;
    }

    public int weight() {                                   // Returns the weight of the edge.
        return weight;
    }

    public int compareTo(WeightedDirectedEdge other) {      // Compares two edges by their weights.
        return Integer.compare(weight, other.weight);
    }
}
