package exercise;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;

    public LinkedListNode(int d) {
        this.data = d;
    }

    public void print() {
        LinkedListNode n = this;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }
}
