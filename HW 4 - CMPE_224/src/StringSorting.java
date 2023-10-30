import java.util.*;

public class StringSorting {

    public static int value(String word) {
        StringBuilder number = new StringBuilder();

        for (char c : word.toCharArray()) {
            int charValue = c - 'a' + 1;
            number.append(charValue).append(" "); // Add a space delimiter between the values
        }

        String[] values = number.toString().trim().split(" "); // Split the string at the spaces

        int totalValue = 0;
        for (String value : values) {
            totalValue = totalValue * 10 + Integer.parseInt(value); // Parse each value and calculate the total
        }

        return totalValue;
    }
    public static int distance(String [] arr1, String[] arr2 , int index) {

        if(arr1[index] == null || arr2[index] == null) {
            return 0;
        }

        int result =  value(arr1[index]) - value(arr2[index]);
        return Math.abs(result);

    }

    public static String sortOdd(String word) {

        char[] letters = word.toCharArray();

        Arrays.sort(letters);

        return new String(letters);

    }

    public static String sortEven(String first, String second) {

        StringBuilder finalString = new StringBuilder();

        for(char ch : second.toCharArray()) {

            int index = first.indexOf(ch);

            if(index != -1) {
                finalString.append(first.charAt(index));
            }
        }

        for(char ch : first.toCharArray()) {

            if(finalString.indexOf(String.valueOf(ch)) == -1) {
                finalString.append(ch);
            }
        }

        return finalString.toString();

    }

}