package LinkedList;

public class NodeInsertion_First_Last {

    private Node head;
    private Node tail;
    private int size=0;

    private class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
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

    public void insertLast(int val)
    {

        Node n=new Node(val);
        tail.next = n;
        tail=n;
        if(tail==null)
        {
            tail=head;
        }
        size++;
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
        NodeInsertion_First_Last n=new NodeInsertion_First_Last();
        n.insertFirst(1);
        n.insertFirst(2);
        n.insertFirst(3);
        n.insertFirst(4);
        System.out.println("List after insertion first:");
        n.display();

        n.insertLast(5);
        n.insertLast(6);
        n.insertLast(7);
        n.insertLast(8);
        System.out.println("List after insertion last:");
        n.display();
    }
}
