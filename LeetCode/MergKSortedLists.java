package LeetCode;// Java code for the above approach
//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
import java.util.*;

class Node2 {
	int data;
	Node2 next;

	Node2(int key)
	{
		data = key;
		next = null;
	}
}

// Class implements Comparator to compare Node data
class NodeComparator implements Comparator<Node2> {

	public int compare(Node2 k1, Node2 k2)
	{
		if (k1.data > k2.data)
			return 1;
		else if (k1.data < k2.data)
			return -1;
		return 0;
	}
}
public class MergKSortedLists {
	// Function to merge k sorted linked lists
	static Node2 mergeKList(Node2[] arr, int K)
	{
		// Priority_queue 'queue' implemented
		// as min heap with the help of
		// 'compare' function
		PriorityQueue<Node2> queue
			= new PriorityQueue<>(new NodeComparator());
		Node2 at[] = new Node2[K];
		Node2 head = new Node2(0);
		Node2 last = head;
		// Push the head nodes of all
		// the k lists in 'queue'
		for (int i = 0; i < K; i++) {
			if (arr[i] != null) {
				queue.add(arr[i]);
			}
		}
		// Handles the case when k = 0
		// or lists have no elements in them
		if (queue.isEmpty())
			return null;
		// Loop till 'queue' is not empty
		while (!queue.isEmpty()) {
			// Get the top element of 'queue'
			Node2 curr = queue.poll();

			// Add the top element of 'queue'
			// to the resultant merged list
			last.next = curr;
			last = last.next;
			// Check if there is a node
			// next to the 'top' node
			// in the list of which 'top'
			// node is a member
			if (curr.next != null) {
				// Push the next node of top node
				// in 'queue'
				queue.add(curr.next);
			}
		}
		// Address of head node of the required
		// merged list
		return head.next;
	}
	// Print linked list
	public static void printList(Node2 node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args)
	{
		int N = 3;
	
		// array to store head of linkedlist
		Node2[] a = new Node2[N];
	
		// Linkedlist1
		Node2 head1 = new Node2(1);
		a[0] = head1;
		head1.next = new Node2(3);
		head1.next.next = new Node2(5);
		head1.next.next.next = new Node2(7);
	
		// Limkedlist2
		Node2 head2 = new Node2(2);
		a[1] = head2;
		head2.next = new Node2(4);
		head2.next.next = new Node2(6);
		head2.next.next.next = new Node2(8);
	
		// Linkedlist3
		Node2 head3 = new Node2(0);
		a[2] = head3;
		head3.next = new Node2(9);
		head3.next.next = new Node2(10);
		head3.next.next.next = new Node2(11);

		Node2 res = mergeKList(a, N);

		if (res != null)
			printList(res);
		System.out.println();
	}
}
