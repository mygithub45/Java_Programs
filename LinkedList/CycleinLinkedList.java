package LinkedList;
// https://leetcode.com/problems/linked-list-cycle
//apply fast and slow pointer methods - slow will run 1 time,fast will move 2 times
//2 pointers will meet at particular node,then cycle is present
public class CycleinLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public CycleinLinkedList() {
        this.size = 0;
    }
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public Node detectCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        Node f = head;
        Node s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // find length of the cycle
    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
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
    /*public static void main(String[] args) {
        CycleinLinkedList lisNode = new CycleinLinkedList();
        lisNode.insertLast(1);
        lisNode.insertLast(2);
        lisNode.insertLast(3);
        lisNode.insertLast(3);
        lisNode.insertLast(3);
        lisNode.insertLast(4);
        lisNode.insertLast(4);
        lisNode.insertLast(4);
        System.out.println("List with cycle:");
        lisNode.display();
        System.out.println("List after removing dups :");
        lisNode.duplicates();
        lisNode.display();
    }*/


}
