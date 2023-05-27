//-----------------------------------------------------
// Title: Bus class
// Author: Mustafa Baran Ercan, Bedir Esen
// ID: 28810555206, 15203509106
// Section: 1
// Assignment: 3
// Description: This class implements the bus methods for out bus class.
//-----------------------------------------------------

public class Bus {
    private int[] route;

    public Bus(int[] route) {  //Bus constructor with route of related bus.
        this.route = route;
    }

    public int getLocationIndex(int time) {  //this method returns the current location of the bus in a specific time.
        //We calculated this with time mod % lenght of the route.
        //Because buses return the first station after the last one.
        return time % route.length;
    }

    public int findWaitingTime(int index, int time) {  //This method finds the waiting time for the destination station.

        if(time > 15) {  // We used this to avoid infinite loop. With this statement we put -1 to stations which are unreachable.
            return -1;
        }

        if (index == getLocationIndex(time)) {   //Here we are arriving the destination statoin and returning the time.
            return time;
        } else {
            return findWaitingTime(index, time + 1); //Here we are calling the method recursively by incrementing the time by 1.
        }
    }
}