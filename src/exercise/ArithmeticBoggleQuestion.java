package exercise;

import java.util.ArrayList;
import java.util.List;

class ArithmeticBoggleQuestion {
    public static boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return magicNumber == 0;
        }

        List<String> signsList = getSignsList(numbers.size());
        for (String signs : signsList) {
            if (arithmeticBoggleCheck(magicNumber, numbers, signs)) {
                return true;
            }
        }

        return false;
    }

    private static List<String> getSignsList(int size) {
        List<String> signs = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, size); i++) {
            String binaryString = Integer.toBinaryString(i);
            while (binaryString.length() < size)
                binaryString = "0" + binaryString;
            signs.add(binaryString);
        }
        return signs;
    }

    private static boolean arithmeticBoggleCheck(int magicNumber, ArrayList<Integer> numbers, String signs) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int value;
            if (signs.charAt(i) == '1') {
                value = numbers.get(i);
            } else {
                value = numbers.get(i) * -1;
            }
            sum += value;
        }
        return sum == magicNumber;
    }

    private static ArrayList<Integer> toArrayList(int[] numbers) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i : numbers) {
            intList.add(i);
        }
        return intList;
    }

    public static void main(String[] args) {
        boolean hasSum1 = arithmeticBoggle(1, toArrayList(new int[] {6,3}));
        boolean hasSum2 = arithmeticBoggle(19, toArrayList(new int[] {1,3,6,9,5,5}));
        boolean hasSum3 = arithmeticBoggle(0, toArrayList(new int[] {}));
        boolean hasSum4 = arithmeticBoggle(43, toArrayList(new int[] {}));
        boolean hasSum5 = arithmeticBoggle(42, toArrayList(new int[] {42}));
        boolean hasSum6 = arithmeticBoggle(0, toArrayList(new int[] {99}));
        int i = 0;
    }


}