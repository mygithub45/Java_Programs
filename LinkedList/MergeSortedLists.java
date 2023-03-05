package LinkedList;
// https://leetcode.com/problems/merge-two-sorted-lists/submissions/
public class MergeSortedLists {
    private Node head;
    private Node tail;
    private int size;

    public MergeSortedLists() {
        this.size = 0;
    }

    private class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
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

    public static MergeSortedLists mergeLists(MergeSortedLists first,MergeSortedLists second)
    {
        Node temp1=first.head;
        Node temp2=second.head;
        MergeSortedLists newList=new MergeSortedLists();
        while(temp1 != null && temp2 !=null)
        {
            if( temp1.value<temp2.value) {
                newList.insertLast(temp1.value);
                temp1 = temp1.next;
            }
            else{
                newList.insertLast(temp2.value);
                 temp2=temp2.next;
            }
        }
        while(temp1 !=null){
            newList.insertLast(temp1.value);
            temp1=temp1.next;
        }
        while(temp2 !=null){
            newList.insertLast(temp2.value);
            temp2=temp2.next;
        }
        return newList;
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
        //list 1
        MergeSortedLists n1=new MergeSortedLists();
        n1.insertFirst(12);
        n1.insertFirst(2);
        n1.insertFirst(1);
        System.out.println("List1:");
        n1.display();
        //list2
        MergeSortedLists n2=new MergeSortedLists();
        n2.insertLast(1);
        n2.insertLast(3);
        n2.insertLast(7);
        n2.insertLast(8);
        System.out.println("List2:");
        n2.display();

        MergeSortedLists mergedList=MergeSortedLists.mergeLists(n1,n2);
        mergedList.display();

    }
}
