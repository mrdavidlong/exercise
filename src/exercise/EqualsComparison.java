package exercise;

public class EqualsComparison {
    public static void main(String[] args) {
        String personalLoan = new String("cheap personal loans");
        String homeLoan = new String("cheap personal loans");

//since two strings are different object result should be false
        boolean result = personalLoan == homeLoan;
        System.out.println("Comparing two strings with == operator: " + result);

//since strings contains same content , equals() should return true
        result = personalLoan.equals(homeLoan);
        System.out.println("Comparing two Strings with same content using equals method: " + result);

        homeLoan = personalLoan;
//since both homeLoan and personalLoand reference variable are pointing to same object
//"==" should return true
        result = (personalLoan == homeLoan);
        System.out.println("Comparing two reference pointing to same String with == operator: " + result);

//        Output:
//        Comparing two strings with == operator: false
//        Comparing two Strings with same content using equals method: true
//        Comparing two references pointing to same String with == operator: true
//
//        Read more: https://javarevisited.blogspot.com/2012/12/difference-between-equals-method-and-equality-operator-java.html#ixzz5fOLVUJr5
    }
}
