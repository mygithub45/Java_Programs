package LeetCode;// Java program for the above approach
import java.util.*;
//https://www.geeksforgeeks.org/next-greater-element-in-the-linked-list/
public class NextGreaterElementLinkedList
{
	ListNode head = null;

	// ListNode
	class ListNode
	{
		int val;
		ListNode next;

		public ListNode(int val)
		{
			this.val = val;
			next = null;
		}
	}

	// Function to reverse the Linked List
	ListNode reverse(ListNode head)
	{
		ListNode prev = null, next = null,
							curr = head;

		while (curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// Function to find the next greater
	// element in the list
	ListNode nextLargerLL(ListNode head)
	{
		if (head == null)
			return head;

		// Dummy Node
		ListNode res = new ListNode(-1);
		ListNode temp = res;

		// Reverse the Linked List
		head = reverse(head);
		Stack<Integer> st = new Stack<>();

		while (head != null)
		{

			// Initial Condition
			if (st.empty())
			{
				temp.next = new ListNode(0);
				st.push(head.val);
			}
			else {

				// Maintain Monotonicity
				// Decreasing stack of element
				while (!st.empty() &&
						st.peek() <= head.val)
					st.pop();

				// Update result Linked List
				if (st.empty())
				{
					temp.next = new ListNode(0);
					st.push(head.val);
				}
				else
				{
					temp.next = new ListNode(st.peek());
					st.push(head.val);
				}
			}
			head = head.next;
			temp = temp.next;
		}
		temp = res;
		res = res.next;

		// Reverse result Linked List
		res = reverse(res);

		return res;
	}

	public void push(int new_data)
	{
		/* allocate node */
		ListNode new_node = new ListNode(new_data);

		/* link the old list of the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;
	}

	// Utility function to print the linked list
	public void printList(ListNode head)
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		NextGreaterElementLinkedList ll = new NextGreaterElementLinkedList();

		ll.push(5);
		ll.push(0);
		ll.push(3);
		ll.push(1);
		ll.push(2);

		// Function Call
		ll.printList(ll.nextLargerLL(ll.head));
	}
}
//Time Complexity: O(N)
//Auxiliary Space: O(N)