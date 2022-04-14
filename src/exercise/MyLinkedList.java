package exercise;

public class MyLinkedList {
    LinkedListNode head = null;
    LinkedListNode tail = null;

    public MyLinkedList() {

    }

    public void appendToTail(int d) {
        LinkedListNode node = new LinkedListNode(d);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

//        LinkedListNode n = head;
//        while (n.next != null) {
//            n = n.next;
//        }
//        n.next = end;
        tail.next = node;
        tail = node;
    }

    public void print() {
        LinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }

    public boolean deleteNode(int d) {
        LinkedListNode node = head;
        if (node.data == d) {
            head = head.next;
            return true;
        }

        while (node.next != null) {
            if (node.next.data == d) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void reverse() {
        if (head == null || head.next == null) return;

        LinkedListNode prev = null;
        LinkedListNode cur = head;
        LinkedListNode next = null;
        tail = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.appendToTail(1);
        ll.appendToTail(2);
        ll.appendToTail(3);
        ll.appendToTail(4);

        ll.print();
        ll.reverse();
        ll.print();
    }

}
