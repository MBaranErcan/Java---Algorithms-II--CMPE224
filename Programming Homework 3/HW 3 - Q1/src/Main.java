//-----------------------------------------------------
// Title: Main class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class is the main class which takes input and calls the other class' methods.
//-----------------------------------------------------

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);                              // Scanner object.

            int N = scan.nextInt();                                             // Numbers of nodes (parking slots).
            int M = scan.nextInt();                                             // Number of edges.
            int F = scan.nextInt();                                             // Parking fee.

            ParkingSlot[] parkingSlots = new ParkingSlot[N];                    // Array of ParkingSlot object.

            for (int x = 0; x < N; x++) {                                       // Get the capacities of parking slots.
                parkingSlots[x] = new ParkingSlot(scan.nextInt(), F);           // Create the N parking slots with the given capacity and fee values.
            }                                                                   // Their ID values starts from 1, increases one by one while creating, and equals x+1.

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(N);             // Instantiate the graph.
            for (int i = 0; i < M; i++) {                                       // Loop to create edges.
                int from = scan.nextInt() - 1;                                  // One endpoint of the edge.
                int to = scan.nextInt() - 1;                                    // The other endpoint of the edge.
                int weight = scan.nextInt();                                    // Weight value of the edge.
                WeightedDirectedEdge e1 = new WeightedDirectedEdge(from, to, weight);   // Instantiate the edges with endpoints and weight values.
                graph.addEdge(e1);                                              // Add edges to thte graph.
            }

            int num_cars = scan.nextInt();                                      // Get the number of cars entering the parkingSlots.

            DijkstraSP dijkstraSP = new DijkstraSP(graph, 0);               // Create the dijkstraSP.
            LinkedList<Integer> costList = new LinkedList<Integer>();          // Linked list to keep costs of trips.

            for (int i = 0; i < num_cars; i++) {                                // For each car, calculate the cost of trip which is starting from the first ParkingSlot,
                int end = -1;                                                   // And ending at an available parkingSlot with min cost.
                for (int j = 0; j < N; j++) {
                    if (parkingSlots[j].getCapacity() > 0) {                    // Check whether the parkingSlot is available.
                        end = j;                                                // If an empty parking slot is found, select that.
                        break;                                                  // No need to look for other empty parking slots.
                    }
                }
                if (end == -1) {                                                // If no available parking slot is found add -1 to the list.
                    costList.add(-1);
                    continue;
                }
                int distance = dijkstraSP.distTo(end);                         // Get the cost of traveling to that particular parking slot.
                costList.add(parkingSlots[end].getParkingFee() + distance);    // Add parking fee to the cost.
                parkingSlots[end].decrementCapacity();                         // Decrease the parking spot's capacity by one car.
            }

            // Until now, we have found the cost for each parking slot available. Now we should appoint these parking spots for each car in order.
            Collections.sort(costList); // In order to do that, we simply sort them so that each car chooses the parking slot with minimum cost.
            int minusOneCount = 0;      // But sorting carries minus ones to the beginning, however they should be printed at the end.
            for (Integer i : costList) {// We keep count of them and print them at the end.
                if (i < 0) {
                    minusOneCount++;
                    continue;
                }
                System.out.print(i + " ");              // Print the costs for each car.
            }
            for (int i = 0; i < minusOneCount; i++) {   // Print also the minus ones.
                System.out.print("-1 ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Input!!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No available ParkingSlot with such number.");
        }
    }
}
