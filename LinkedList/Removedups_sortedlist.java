package LinkedList;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list
public class Removedups_sortedlist {
    private Node head;
    private Node tail;
    private int size;

    public Removedups_sortedlist() {
        this.size = 0;
    }


    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
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
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public void display()
    {
      Node temp=head;
        while(temp !=null){
            System.out.print(temp.value+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Removedups_sortedlist lisNode = new Removedups_sortedlist();
        lisNode.insertLast(2);
        lisNode.insertLast(2);
        lisNode.insertLast(2);
        lisNode.insertLast(3);
        lisNode.insertLast(3);
        lisNode.insertLast(4);
        lisNode.insertLast(4);
        lisNode.insertLast(4);
        System.out.println("List before removing dups:");
        lisNode.display();
        System.out.println("List after removing dups :");
        lisNode.duplicates();
        lisNode.display();
    }
}
