package LinkedList;

public class NodeInsert_Delete_Get_FindVal {
    private Node head;
    private Node tail;
    private int size;

    public NodeInsert_Delete_Get_FindVal() {
        this.size = 0;
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
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
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

    public void insert(int val, int index) {
        /*if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
*/
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    public void display() {
       Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        NodeInsert_Delete_Get_FindVal lisNode = new NodeInsert_Delete_Get_FindVal();
        lisNode.insertFirst(4);
        lisNode.insertFirst(2);
        lisNode.insertLast(8);
        lisNode.insertLast(18);
        System.out.println("List :");
        lisNode.display();
        System.out.println("Insert 88 at index 2 :");
        System.out.println("List after insertion at given index :");
        lisNode.insert(88,2);
        System.out.println("Insert 7 at index 2 :");
        System.out.println("List after insertion at given index :");
        lisNode.insert(7,2);
        lisNode.display();
        System.out.println("get element at 3rd index :"+lisNode.get(3).value);

        System.out.println("List after deletion at first index :");
        lisNode.deleteFirst();
        lisNode.display();
        System.out.println("List after deletion at last index :");
        lisNode.deleteLast();
        lisNode.display();
        System.out.println("List after deletion at given index 2:");
        lisNode.delete(2);
        lisNode.display();
        System.out.println("find node with value 7:"+lisNode.find(7).value);


    }
}
