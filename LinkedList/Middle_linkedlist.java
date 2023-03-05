package LinkedList;

// https://leetcode.com/problems/middle-of-the-linked-list/submissions/
//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/18-linkedlist/code/src/com/kunal/InterviewQuestions.java
// based on fast n slow pointer, by the time fast reaches end,slow is at half
public class Middle_linkedlist {
    private Node head;
    private Node tail;
    private int size;
    public Node middleNode() {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value,Node next) {
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
        Middle_linkedlist lisNode = new Middle_linkedlist();
        lisNode.insertLast(2);
        lisNode.insertLast(21);
        lisNode.insertLast(12);
        lisNode.insertLast(13);
        lisNode.insertLast(23);
        System.out.println("List :");
        lisNode.display();

        System.out.println("middle node value is :"+lisNode.middleNode().value);

        Middle_linkedlist lisNode1 = new Middle_linkedlist();
        lisNode1.insertLast(2);
        lisNode1.insertLast(21);
        lisNode1.insertLast(12);
        lisNode1.insertLast(13);
        lisNode1.insertLast(23);
        lisNode1.insertLast(43);
        System.out.println("List :");
        lisNode1.display();

        System.out.println("middle node value is :"+lisNode1.middleNode().value);

    }
}
