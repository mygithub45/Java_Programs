package LinkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.val + " -> ");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }

        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);

    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        CircularLinkedList n = new CircularLinkedList();
        n.insert(4);
        n.insert(2);
        n.insert(8);
        n.insert(18);
        System.out.println("Circular linked list:");
        n.display();
        System.out.println("Circular linked list delete 8");
        n.delete(8);
        System.out.println("Circular linked list after delete:");
        n.display();
        CircularLinkedList n1 = new CircularLinkedList();
        n1.insert(4);
        System.out.println("Circular linked list single node:");
        n1.display();

    }
}
