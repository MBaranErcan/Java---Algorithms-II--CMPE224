//-----------------------------------------------------
// Title: Main class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class is the main class which takes input and calls the other class' methods.
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//In this question by using the shortest path algorithm of dijkstra, we tried to calculate minimum time to reach
//other vertices from the source vertice. Firstly, we took inputs and created our digraph according to bus routes.
//Also, we stored each bus objects and their routes in a list. After that, by using the dijkstra we found the shortest paths in our edge weighted digraph.
//Later, by using our bus class methods , we added waiting times to these values. We checked the availability of the buses at current time in these methods.


public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Read the number of stations and buses.
        int stationNumber = keyboard.nextInt();
        int busNumber = keyboard.nextInt();

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(stationNumber); //Creating the graph with stationNumber vertices.


        ArrayList<Bus> buses = new ArrayList<>();  //Creating a bus array list to keep track of the bus objects.


        for (int i = 0; i < busNumber; i++) {  //Take information for each bus.

            int stationsOfBus = keyboard.nextInt();  //take number of stations for each bus.

            int[] route = new int[stationsOfBus]; //Create a  route array to store route of each bus.

            // Read the  route of the bus.
            for (int j = 0; j < stationsOfBus; j++) {
                route[j] = keyboard.nextInt() - 1;
            }

            buses.add(new Bus(route));  //Adding this bus to buses list with its route.

            // Create edges between stations based on the bus rotation.
            for (int j = 0; j < stationsOfBus - 1; j++) {
                int v = route[j];
                int w = route[j + 1];

                WeightedDirectedEdge e = new WeightedDirectedEdge(v, w, 1);
                graph.addEdge(e);
            }

            // Create an edge between the last and first station of the bus rotation.
            int v = route[stationsOfBus - 1];
            int w = route[0];
            WeightedDirectedEdge e = new WeightedDirectedEdge(v, w, 1);
            graph.addEdge(e);
        }

        int[] distances = new int[stationNumber];   //filling the distance array with -1 except the first vertices.
        Arrays.fill(distances, -1);
        distances[0] = 0;

        // Calculate the shortest paths using Dijkstra's algorithm but with this call we are not considering the waiting times.
        DijkstraSP dijkstra = new DijkstraSP(graph, 0);

        //take the values from the dijkstra algorithm.
        for(int i = 1; i< graph.V(); i++) {
            distances[i] = dijkstra.distTo(i);
        }

        // Update distances considering waiting times for each station

        for (int i = 1; i < stationNumber; i++) {
            int time = 0;
            int result = buses.get(i - 1).findWaitingTime(i, time);
            distances[i] += result;
        }

        // Print the resulting distances for each station
        for (int i = 1; i < stationNumber; i++) {
            System.out.print(distances[i] + " ");
        }
    }
}