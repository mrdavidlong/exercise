package exercise;

public class MaxOccuringCharacterMulitThread {
// Java program to output the maximum occurring character in a string with multi threading
    static final int CHAR_SIZE = 256;
    static final int NUM_OF_CPU = 4;
    static char getMaxOccuringChar(String str) {
        int[][] counts = getOccuringCounts(str);

        // merge counts
        int[] combineCount = new int[CHAR_SIZE];
        for (int i = 0; i < NUM_OF_CPU; i++) {
            for (int j = 0; j < CHAR_SIZE; j++) {
                combineCount[j] += counts[i][j];
            }
        }


        int max = 0;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < combineCount.length; i++) {
            if (combineCount[i] > max) {
                max = combineCount[i];
                result = (char)i;
            }
        }

        return result;
    }

    static int[] getOccuringCount(String str) {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[CHAR_SIZE];

        // Construct character count array from the input string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;
        return count;
    }

    static int[][] getOccuringCounts(String str) {
        int chunkSize = (int)Math.ceil(str.length()/(double)NUM_OF_CPU);
        int[][] counts = new int[NUM_OF_CPU][chunkSize];
        int start = 0;
        int end = chunkSize;
        for (int i = 0; i < NUM_OF_CPU; i++) {
            counts[i] = getOccuringCount(str.substring(start, Math.min(end, str.length())));
            start += chunkSize;
            end += chunkSize;
        }
        return counts;
    }


    // Driver Method
    public static void main(String[] args)
    {
        String str = "abcdeabcdeabcdeaaaa";
        System.out.println("Max occurring character is " + getMaxOccuringChar(str));
    }
}
