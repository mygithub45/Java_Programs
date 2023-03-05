package LinkedList;
//merge sort

public class MergeSort_Bubblesort {

    private ListNode head;
    private ListNode tail;
    private int size;

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertFirst(int val) {

        ListNode n = new ListNode(val);
        n.next = head;
        head = n;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }
    public ListNode get(int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }



    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            ListNode first = get(col);
            ListNode second = get(col + 1);

            if (first.val> second.val) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    public static void main(String[] args) {
        MergeSort_Bubblesort lisNode = new MergeSort_Bubblesort();
        lisNode.insertLast(2);
        lisNode.insertLast(21);
        lisNode.insertLast(12);
        lisNode.insertLast(13);
        lisNode.insertLast(23);
        System.out.println("List :");
        lisNode.display();

        System.out.println("sorted list with merge sort :");
        lisNode.sortList(lisNode.head);
        lisNode.display();

        MergeSort_Bubblesort lisNode1 = new MergeSort_Bubblesort();
        lisNode1.insertLast(12);
        lisNode1.insertLast(26);
        lisNode1.insertLast(2);
        lisNode1.insertLast(8);
        lisNode1.insertLast(76);
        System.out.println("List :");
        lisNode1.display();
        System.out.println("sorted list with bubble sort :");
        lisNode1.bubbleSort();
        lisNode1.display();

    }
}
