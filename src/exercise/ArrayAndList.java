package exercise;

import java.util.Arrays;
import java.util.List;

public class ArrayAndList {
    public void givenUsingCoreJava_whenListConvertedToArray_thenCorrect() {
        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
        Integer[] targetArray = sourceList.toArray(new Integer[sourceList.size()]);
    }

    public void givenUsingCoreJava_whenArrayConvertedToList_thenCorrect() {
        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
        List<Integer> targetList = Arrays.asList(sourceArray);
    }

    public static void main(String[] args) {
        ArrayAndList sol = new ArrayAndList();
        sol.givenUsingCoreJava_whenListConvertedToArray_thenCorrect();
        sol.givenUsingCoreJava_whenArrayConvertedToList_thenCorrect();
    }
}
