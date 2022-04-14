package exercise;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * Java Program to sort the array in descending order.
 * Object array can be sorted in reverse order by using
 * Array.sort(array, Comparator) method but primitive
 * array e.g. int[] or char[] can only be sorted
 * in ascending order. For opposite order, just
 * reverse the array.
 *
 */

public class ArraySorter {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        // option 1
        Integer[] array = new Integer[] { 1, 24, 4, 4, 345 };
        Arrays.sort(array, comparator);


        // sorting Integer array in descending order
        Integer[] cubes = new Integer[] { 8, 27, 64, 125, 256 };
        System.out.println("Integer array before sorting : "
                + Arrays.toString(cubes));
        System.out.println("sorting array in descending order");

        Arrays.sort(cubes, Collections.reverseOrder());
        System.out.println("array after sorted in reverse order: "
                + Arrays.toString(cubes));

        // sorting primitive array int[] in descending order
        int[] squares = { 4, 25, 9, 36, 49 };

        System.out.println("int[] array before sorting : "
                + Arrays.toString(squares));
        System.out.println("sorting array in ascending order");

        //Arrays.sort(squares, Collections.reverseOrder());
        System.out.println("reversing array in place");
        reverse(squares);
        System.out.println("Sorted array in descending order : "
                + Arrays.toString(squares));

    }

    /**
     * reverse given array in place
     *
     * @param input
     */
    public static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }

}


//Read more: http://www.java67.com/2016/07/how-to-sort-array-in-descending-order-in-java.html#ixzz5S5UnmqAg