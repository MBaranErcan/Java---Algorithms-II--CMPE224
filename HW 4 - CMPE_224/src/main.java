import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("First Array:");

        String line1 = keyboard.nextLine();

        String arr1[] =  line1.split(" ");

        System.out.println("Second array:");

        String line2 = keyboard.nextLine();

        String arr2[] = line2.split(" ");


        System.out.println("Sorted Array:");

        for(int i = 0; i< arr1.length;i++) {

            if(arr1[i] == null || arr2[i] == null) {
                continue;
            }

            int distance = StringSorting.distance(arr1, arr2, i);

            if(distance % 2 == 1) {

                System.out.print(StringSorting.sortOdd(arr1[i]) + " ");
                System.out.println("odd");

            } else {

                System.out.print( StringSorting.sortEven(arr1[i], arr2[i])+ " " );
                System.out.println("even");

            }
        }
    }




}