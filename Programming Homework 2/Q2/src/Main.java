//-----------------------------------------------------
// Title: Farmland Main class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class is the Main class for the second question.
//-----------------------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           // Scanner object.

        try {
            int caseCount = scanner.nextInt();              // First, we need to get the number of test cases from the user.
            if (caseCount < 1)                              // Check if the number of the test cases are positive integers.
                System.out.println("Number of cases should be a positive integer.");

            for (int i = 0; i < caseCount; i++){            //For each test case, we need to get the number of rows and columns in the grid.

                int rowCount = scanner.nextInt();           // Get the row count.
                int colCount = scanner.nextInt();           // Get the column count.

                if (rowCount < 1 || colCount < 1) {         // If either rowCount or colCount is less than 1, return 0.
                    System.out.println("0");
                    return;
                }
                if (rowCount == 1 && colCount == 1) {       // Also, if both R and C are == 1; return 0;
                    System.out.println("0");
                    return;
                }

                int u1 = scanner.nextInt() -1, v1 = scanner.nextInt()-1; // Starting index. (We subtract 1 bc index starts from 0)
                int u2 = scanner.nextInt() -1, v2 = scanner.nextInt()-1; // Ending index. (We subtract 1 bc index starts from 0)

                if (u1>=rowCount|| v1>=colCount || u2>=rowCount || v2>=colCount) {  // If any of the indices are out of range, print an error message and return.
                    System.out.println("Start-end indices should be in the range");
                    return;
                }

                int[][] grid = new int[rowCount][colCount]; // Create a 2D array to store the grid values.

                for (int m = 0; m < rowCount; m++) {        // Fill rows with scanner input.
                    for (int n = 0; n < colCount; n++) {    // Fill columns with scanner input.
                     grid[m][n] = scanner.nextInt();        // Get the scanner values and assign them to grid.
                    }
                }

                EdgeWeightedGraph graph = new EdgeWeightedGraph(rowCount * colCount);   // Create an edge-weighted graph with (rowCount * colCount) vertices.

                for (int m = 0; m < rowCount; m++) {                                                    // Find weights for edges that are in between one row using xor.
                    for (int n = 0; n < colCount-1; n++) {
                        int e_weight = xor(grid[m][n],grid[m][n+1]);                                    // Calculate the weight of the edge using xor method.
                        Edge e = new Edge(m * colCount + n, m * colCount + n + 1, e_weight);     // Create edge with current indexes.
                        graph.addEdge(e);                                                               // Add edge to the graph.
                    }
                }

                for (int m = 0; m < rowCount-1; m++) {                                                  // Find weights for edges that are in between one column using xor.
                    for (int n = 0; n < colCount; n++) {
                        int e_weight = xor(grid[m][n], grid[m + 1][n]);                                 // Calculate the weight of the edge using xor method.
                        Edge e = new Edge(m * colCount + n, (m + 1) * colCount + n, e_weight);   // Create edge with current indexes and weight.
                        graph.addEdge(e);                                                               // Add edge to the graph.
                    }
                }

                MST mst = new MST(graph, u1 * colCount + v1);                               // Create a minimum spanning tree from the graph starting from u1 * colCount + v1 vertex

                System.out.println(mst.weight());                                                       // Print the weight.

            }
        } catch (InputMismatchException e) {                    // Catch if there is any input mismatch Exception.
            System.out.println("Invalid input format");
        }
    }

    public static String decimalToBinary(int decimal) {         // Takes an decimal int variable, returns its binary String value.
        String binaryStr = Integer.toBinaryString(decimal);     // Use built-in method to convert decimal to binary string
        return binaryStr;
    }

    public static int binaryTODecimal(String binaryStr) {       // Takes a binary String variable, returns its decimal int variable.
        int decimal = Integer.parseInt(binaryStr, 2);     // Use built-in method to parse binary string to decimal integer
        return decimal;
    }

    public static int xor(int v_int, int w_int) {               // Takes two integer weight values, v and w.
        String v = decimalToBinary(v_int);                      // Converts v to its binary value and keeps it as a String.
        String w = decimalToBinary(w_int);                      // Converts w to its binary value and keeps it as a String.

        int maxLen = Math.max(v.length(), w.length());          // Find the maximum length of the two strings.

        v = String.format("%" + maxLen + "s", v).replace(' ', '0'); // Fill the shorter by adding leading zeros to it.
        w = String.format("%" + maxLen + "s", w).replace(' ', '0');

        StringBuilder result = new StringBuilder();  // Variable to store the result.

        for (int i = 0; i < maxLen; i++) {          // Perform the XOR operation on each pair of bits.
            if (v.charAt(i) == w.charAt(i)) {
                result.append('0');                 // If the chars are same, insert 0.
            } else {
                result.append('1');                 // If the chars are different, insert 1.
            }
        }
        int decimalResult = binaryTODecimal(result.toString()); // Convert the binary String result back to decimal.

        return decimalResult;                       // Return the decimal int result.
    }

}
