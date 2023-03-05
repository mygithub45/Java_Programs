package LinkedList;
//using recursion

public class Reverse_recursion_inplace_part {

    private Node head;
    private Node tail;
    private int size;
    // recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void reverse() {
        if(head==null){
            return;
        }
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
    //reverse only part of sublist as per given left and right
    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            System.out.println("Iteration i value:"+i);
            prev = current;
            System.out.println("prev:"+prev.val);
            current = current.next;
            System.out.println("current:"+current.val);
        }

        Node last = prev;
        System.out.println("last:"+last.val);
        Node newEnd = current;
        System.out.println("new end:"+newEnd.val);
        // reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            System.out.println("Iteration for reverse b/w left n right i value:"+i);
            current.next = prev;

            prev = current;
            System.out.println("prev:"+prev.val);
            current = next;
            System.out.println("current:"+current.val);
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        System.out.println("new end:"+newEnd.val);
        return head;
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        Node(int x) {
            val = x;
            next = null;
        }
    }
    public void display()
    {
        Node temp=head;
        while(temp !=null){
            System.out.print(temp.val+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertFirst(int val)
    {

        Node n=new Node(val);
        n.next = head;
        head=n;
        if(tail==null)
        {
            tail=head;
        }
        size++;
    }

    public static void main(String[] args) {
        Reverse_recursion_inplace_part lisNode = new Reverse_recursion_inplace_part();
        lisNode.insertLast(2);
        lisNode.insertLast(21);
        lisNode.insertLast(12);
        lisNode.insertLast(13);
        lisNode.insertLast(23);
        System.out.println("List :");
        lisNode.display();

        System.out.println("reverse of linkedlist using recursion is ");

       lisNode.reverse(lisNode.head);
        lisNode.display();
        System.out.println("reverse of linkedlist in place is ");

        lisNode.reverse();

        lisNode.display();

        System.out.println("reverse only part of linkedlist whose left is 21 and right is 13 : ");

        lisNode.reverseBetween(lisNode.head,2,4); //left and right are positions

        lisNode.display();

    }
}
