package exercise;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bs = new BitSet(100);
        boolean isSet = bs.get(0);
        bs.set(0);
        boolean isSet1 = bs.get(0);
        boolean isSet2 = bs.get(1);
        bs.set(1);
        boolean isSet3 = bs.get(1);
    }
}
