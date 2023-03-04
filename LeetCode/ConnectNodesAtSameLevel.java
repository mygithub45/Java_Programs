package LeetCode;// Iterative Java program to connect NodeKs at same level
// using constant extra space

// A binary tree NodeK
class NodeK
{
	int data;
	NodeK left, right, nextRight;

	NodeK(int item)
	{
		data = item;
		left = right = nextRight = null;
	}
}

class BinaryTree
{
	NodeK root;

	/* This function returns the leftmost child of NodeKs at the same level
	as p. This function is used to getNExt right of p's right child
	If right child of is NULL then this can also be used for the
	left child */
	NodeK getNextRight(NodeK p)
	{
		NodeK temp = p.nextRight;

		/* Traverse NodeKs at p's level and find and return
		the first NodeK's first child */
		while (temp != null)
		{
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}

		// If all the NodeKs at p's level are leaf NodeKs then return NULL
		return null;
	}

	/* Sets nextRight of all NodeKs of a tree with root as p */
	void connect(NodeK p) {
		NodeK temp = null;

		if (p == null)
			return;

		// Set nextRight for root
		p.nextRight = null;

		// set nextRight of all levels one by one
		while (p != null)
		{
			NodeK q = p;

			/* Connect all children NodeKs of p and children NodeKs of all other
			NodeKs at same level as p */
			while (q != null)
			{
				// Set the nextRight pointer for p's left child
				if (q.left != null)
				{
				
					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.right != null)
						q.left.nextRight = q.right;
					else
						q.left.nextRight = getNextRight(q);
				}

				if (q.right != null)
					q.right.nextRight = getNextRight(q);

				// Set nextRight for other NodeKs in pre order fashion
				q = q.nextRight;
			}

			// start from the first NodeK of next level
			if (p.left != null)
				p = p.left;
			else if (p.right != null)
				p = p.right;
			else
				p = getNextRight(p);
		}
	}
	
	/* Driver program to test above functions */
	public static void main(String args[])
	{
		/* Constructed binary tree is
				10
			/ \
			8	 2
		/		 \
		3		 90
		*/
		BinaryTree tree = new BinaryTree();
		tree.root = new NodeK(10);
		tree.root.left = new NodeK(8);
		tree.root.right = new NodeK(2);
		tree.root.left.left = new NodeK(3);
		tree.root.right.right = new NodeK(90);

		// Populates nextRight pointer in all NodeKs
		tree.connect(tree.root);
		
		// Let us check the values of nextRight pointers
		int a = tree.root.nextRight != null ?
									tree.root.nextRight.data : -1;
		int b = tree.root.left.nextRight != null ?
								tree.root.left.nextRight.data : -1;
		int c = tree.root.right.nextRight != null ?
								tree.root.right.nextRight.data : -1;
		int d = tree.root.left.left.nextRight != null ?
								tree.root.left.left.nextRight.data : -1;
		int e = tree.root.right.right.nextRight != null ?
								tree.root.right.right.nextRight.data : -1;
		
		// Now lets print the values
		System.out.println("Following are populated nextRight pointers in "
				+ " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + tree.root.data + " is " + a);
		System.out.println("nextRight of " + tree.root.left.data
													+ " is " + b);
		System.out.println("nextRight of " + tree.root.right.data +
														" is " + c);
		System.out.println("nextRight of " + tree.root.left.left.data +
															" is " + d);
		System.out.println("nextRight of " + tree.root.right.right.data +
															" is " + e);
	}
}

// This code has been contributed by Mayank Jaiswal
//Time Complexity : O(n)
//Auxiliary Space: O(1)