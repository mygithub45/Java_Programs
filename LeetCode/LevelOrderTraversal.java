package LeetCode;// Iterative Queue based Java program
// to do level order traversal
// of Binary Tree
//https://www.geeksforgeeks.org/level-order-tree-traversal/
/* importing the inbuilt java classes
required for the program */
import java.util.LinkedList;
import java.util.Queue;

/* Class to represent Tree node */


/* Class to print Level Order Traversal */
public class LevelOrderTraversal {
static	class Node {
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = null;
			right = null;
		}
	}
	Node root;

	/* Given a binary tree. Print
	its nodes in level order
	using array for implementing queue */
	void printLevelOrder()
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/* poll() removes the present head.
			For more information on poll() visit
			http://www.tutorialspoint.com/java/
			util/linkedlist_poll.htm */
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/*Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/*Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String args[])
	{
		/* creating a binary tree and entering
		the nodes */
		LevelOrderTraversal tree_level = new LevelOrderTraversal();
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}
}
//Time Complexity: O(N) where n is the number of nodes in the binary tree.
//Auxiliary Space: O(N) where n is the number of nodes in the binary tree.