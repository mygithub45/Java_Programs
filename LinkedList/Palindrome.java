package LinkedList;

public class Palindrome {
    // linkedin, google, facebook, microsoft, amazon, apple
//    https://leetcode.com/problems/palindrome-linked-list/

    private Node head;
    private Node tail;
    private int size;
    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }
    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }



    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public Node reverseList(Node head) {
        if (head == null) {
            return head;
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
        return prev;
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
        Palindrome lisNode = new Palindrome();
        lisNode.insertLast(1);
        lisNode.insertLast(2);
        lisNode.insertLast(3);
        lisNode.insertLast(2);
        lisNode.insertLast(1);
        System.out.println("List :");
        lisNode.display();
        System.out.println("is list with odd number of nodes palindrome: "+lisNode.isPalindrome(lisNode.head));

        Palindrome lisNode1 = new Palindrome();
        lisNode1.insertLast(1);
        lisNode1.insertLast(2);
        lisNode1.insertLast(3);
        lisNode1.insertLast(3);
        lisNode1.insertLast(2);
        lisNode1.insertLast(1);
        System.out.println("List :");
        lisNode1.display();
        System.out.println("is list with even number of nodes palindrome: "+lisNode1.isPalindrome(lisNode1.head));

        Palindrome lisNode3 = new Palindrome();
        lisNode3.insertLast(1);
        lisNode3.insertLast(2);
        lisNode3.insertLast(4);
        lisNode3.insertLast(5);
        lisNode3.insertLast(2);
        lisNode3.insertLast(1);
        System.out.println("List :");
        lisNode3.display();
        System.out.println("is list  palindrome: "+lisNode3.isPalindrome(lisNode3.head));


    }

}
