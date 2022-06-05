package exercise;

import java.util.Objects;

public class ChildClass extends BaseClass {
    public ChildClass() {
        super();
        System.out.println("out: ChildClass");
        //System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        System.out.println("hi");
    }
}
