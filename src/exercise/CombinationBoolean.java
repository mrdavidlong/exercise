package exercise;

import java.util.ArrayList;
import java.util.List;

public class CombinationBoolean {
    public static void main(String[] args) {
        List<String> result = getBinaryStringsUsingIntBinString(3);
        for (String s : result) {
            System.out.println(s);
        }

        List<String> result2 = getBinaryStrings(2, 3);
        for (String s : result2) {
            System.out.println(s);
        }

        List<String> result3 = getBinaryStrings(3, 3);
        for (String s : result3) {
            System.out.println(s);
        }
    }

//    public static List<String> getBinaryStrings(int n){
//        ArrayList<String> result = new ArrayList<>();
//        getBinaryStringsCore(n, "", result);
//        return result;
//    }
//
//    private static void getBinaryStringsCore(int n, String tempString, List<String> result){
//        if (tempString.length() == n) {
//            result.add(tempString);
//            return;
//        }
//
//        tempString += "0";
//        getBinaryStringsCore(n, tempString, result);
//
//        tempString = tempString.substring(0, tempString.length() - 1);
//        tempString = tempString + "1";
//        getBinaryStringsCore(n, tempString, result);
//    }
//
//

public static List<String> getBinaryStrings(int base, int n){
    ArrayList<String> result = new ArrayList<>();
    getBinaryStringsCore(base, n, "", result);
    return result;
}

private static void getBinaryStringsCore(int base, int n, String tempString, List<String> result){
    if (tempString.length() == n) {
        result.add(tempString);
        return;
    }

    for (int i = 0; i < base; i++) {
        tempString += i;
        getBinaryStringsCore(base, n, tempString, result);
        tempString = tempString.substring(0, tempString.length() - 1);
    }
}


    public static List<String> getBinaryStringsUsingIntBinString(int size) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, size); i++) {
            String bin = Integer.toBinaryString(i);
            while (bin.length() < size)
                bin = "0" + bin;
            result.add(bin);
        }
        return result;
    }
}
