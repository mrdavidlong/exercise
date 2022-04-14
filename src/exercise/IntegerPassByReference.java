package exercise;

//https://www.techiedelight.com/pass-integer-reference-java/
class IntHolder {
    public Integer value;

    IntHolder(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

public class IntegerPassByReference {

    public static void increment(int[] arr) {
        arr[0]++;
    }


    public static void modify(IntHolder i) {
        i.value = 10;
    }

    public static void main(String[] args) {
        // method 1: using wrapper class
        IntHolder i = new IntHolder(2);
        modify(i);

        System.out.println(i);

        // method 2; using array
        int j = 10;
        int[] arr = { j };

        increment(arr);
        System.out.println(arr[0]);
    }
}