package exercise;

public class StringExample {
    public static void main(String[] args) {

        String s = "aaa";
        change(s);
        System.out.println(s); // aaa
    }

    public static void change(String s) {
        s += "bbb";
        System.out.println(s); // aaabbb
    }
}
