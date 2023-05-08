//-----------------------------------------------------
// Title: Uber Company Main class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class runs the Main class.
//-----------------------------------------------------
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of taxi pickups:");
        int V = scan.nextInt(); // Takes the number of taxi pickups from the user.
        if (V < 0) {            // Checks if V is greater than 0.
            System.out.println("Invalid input!");
            return;
        }

        System.out.println("Enter the number of taxi rides:");
        int E = scan.nextInt(); // Takes the number of taxi rides from the user.
        if (E < 0) {            // Checks if E is greater than 0.
            System.out.println("Invalid input!!!");
            return;
        }

        Digraph graph = new Digraph(V); // Create a new Digraph object with V vertices

        System.out.println("Enter the taxi rides:");    // Takes the taxi rides input from the user.
        int index = 0;                                  // Index value to keep track of the districts ID. We use this integer ID value to add those District objects to the graph.
        District[] districts = new District[E * 2];     // Array to store the Districts. (It is double the size of E because it stores "to" and "from" values separately.)
        for (int i = 0; i < E; i++) {                   // Loop through each taxi ride.
            String from = scan.next();                  // Add "to" and "from" values to the graph.
            String to = scan.next();

            District fromDistrict = null;               // Initialize the from and to Districts to Null.
            District toDistrict = null;

            for (int j = 0; j < index; j++) {               // Check whether the "from" value already exists as a District in the districts array.
                if (districts[j].getName().equals(from)) {  // If they already exist, do not create another distinct with that name, but use the already existing distinct value.
                    fromDistrict = districts[j];
                }
                if (districts[j].getName().equals(to)) {    // Does the same for "to".
                    toDistrict = districts[j];
                }

            }
            if (fromDistrict == null) {                     // If the "from" district doesn't exist already (if it is new, it is null).
                fromDistrict = new District(index, from);   // assign values for this new District object and add it to the districts array.
                districts[index] = fromDistrict;
                index++;
            }
            if (toDistrict == null) {                       // If the "to" district doesn't exist already (if it is new, it is null).
                toDistrict = new District(index, to);       // assign values for this new District object and add it to the districts array.
                districts[index] = toDistrict;
                index++;
            }

            graph.addEdge(fromDistrict, toDistrict);        // Add the taxi ride to the graph.
        }

        for (District v : districts){   // Print out the adjacency list for each district in the graph.
            if (v == null) { continue;} // NUll point check before calling, so it doesn't throw an Exception.
                System.out.print(v.getName() + ":");
            for (District w : graph.adj(v)) {
                if (w != null)          // NUll point check before calling, so it doesn't throw an Exception.
                    System.out.print(" " + w.getName());
            }
            System.out.println("");
        }

        if (graph.checkIfTree()) {  // Print whether the graph can be represented as a tree or not.
            System.out.println("This ride network can be kept in a tree structure.");
        } else {
            System.out.println("This ride network cannot be kept in a tree structure.");
        }
    }
}
