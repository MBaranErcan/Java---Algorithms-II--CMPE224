//-----------------------------------------------------
// Title: Uber Company District class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class implements the District class for the first question.
//-----------------------------------------------------

public class District {     // We use District objects as vertices for graph. They have names and id.
    private int id;         // The unique id for the district.
    private String name;    // The name of the district.

    public District(int id, String name) {   // Constructor to create a new District object with the given id and name.
        this.id = id;
        this.name = name;
    }

    public int getId() {    // Method to get the id of the district.
        return id;
    }

    public String getName() {   // Method to get the name of the district.
        return name;
    }
}
