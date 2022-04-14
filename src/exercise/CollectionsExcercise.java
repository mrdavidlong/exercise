package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by davidlong on 7/4/18.
 */
public class CollectionsExcercise {
    public static void main(String[] args) {
        int[] a = {1,2,4,5,3};
        Arrays.sort(a);
        //List<Integer> myList = new ArrayList<>(Arrays.asList(a));
        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        Integer[] aBoxed = new Integer[] {4,3,5,2,1};
        List<Integer> aList2 = new ArrayList<>(Arrays.asList(aBoxed));

        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
        List<Integer> aListCopy = new ArrayList<>(aList2);
        aListCopy.remove(0);


        Arrays.sort(a);
        Collections.sort(aList2, Comparator.<Integer>reverseOrder());

        Integer[] aFromSet = aSet.toArray(new Integer[0]);

        Set<String> set = new HashSet<>(Arrays.asList("a", "b"));
        String[] sArray = set.toArray(new String[set.size()]);

        // error
        // int[] aFromList = aList.toArray(new int[aList.size()]);

        int i = 0;
    }


    //https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static int[] convertIntegers2(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
}
