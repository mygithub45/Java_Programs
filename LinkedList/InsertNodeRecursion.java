package LinkedList;

public class InsertNodeRecursion {


        private Node head;
        private Node tail;
        private int size;

        public InsertNodeRecursion() {
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

    // insert using recursion
        public void insertRec(int val, int index) {
            head = insertRec(val, index, head);
        }
        private Node insertRec(int val, int index, Node node) {
            if (index == 0) {
                Node temp = new Node(val, node);
                size++;
                return temp;
            }

            node.next = insertRec(val, index-1, node.next);
            return node;
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
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    public static void main(String[] args) {
        InsertNodeRecursion lisNode = new InsertNodeRecursion();
        lisNode.insertFirst(4);
        lisNode.insertFirst(2);
        lisNode.insertFirst(8);
        lisNode.insertFirst(18);
        System.out.println("List :");
        lisNode.display();
        System.out.println("Insert 88 at index 2 :");
        System.out.println("List after insertion at given index :");
        lisNode.insertRec(88,2);
        lisNode.display();
    }

    }
