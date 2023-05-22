//-----------------------------------------------------
// Title: ParkingSlot class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class implements the ParkingSlot Class which works as a Node for the Graph class.
//-----------------------------------------------------

public class ParkingSlot implements Comparable<ParkingSlot> {   // ParkingSlot is a Node.
    private int capacity;                                       // The capacity of parking slot.
    private final int parkingFee;                               // The parking fee of parking slot.

    public ParkingSlot(int capacity, int parkingFee) {          // Constructor that takes the capacity and parking fee as an input.
        this.capacity = capacity;                               // Initializes the capacity.
        this.parkingFee = parkingFee;                           // Initializes the parking fee.
    }

    public int getCapacity() {                                  // Getter method for the capacity.
        return capacity;
    }

    public int getParkingFee() {                                // Getter method for the parking fee.
        return parkingFee;
    }

    public void decrementCapacity() {                           // Method to decrement the capacity of the parking slot by 1.
        capacity--;
    }

    public int compareTo(ParkingSlot other) {                   // Method to compare two parking slots by their parking fees.
        return Integer.compare(parkingFee, other.parkingFee);
    }
}
