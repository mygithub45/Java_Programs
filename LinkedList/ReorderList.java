package LinkedList;

public class ReorderList {
    // linkedin, google, facebook, microsoft, amazon, apple
//    https://leetcode.com/problems/palindrome-linked-list/

    private Node head;
    private Node tail;
    private int size;
    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
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

            prev = newEnd;
            count--;
        }
        return head;
    }

    public int getLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // https://leetcode.com/problems/reorder-list/
// Google, Facebook
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);

        Node hs = reverseList(mid);
        Node hf = head;

        // rearrange
        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
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
        ReorderList lisNode = new ReorderList();
        lisNode.insertLast(1);
        lisNode.insertLast(2);
        lisNode.insertLast(3);
        lisNode.insertLast(4);
        lisNode.insertLast(5);
        lisNode.insertLast(6);
        lisNode.insertLast(7);
        System.out.println("List :");
        lisNode.display();

        lisNode.reorderList(lisNode.head);


        System.out.println("List after reordering:");
        lisNode.display();





    }

}
