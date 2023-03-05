package Trees;
import java.io.*;
public class RightView_BST {


    // Java program for Right view of BST


        // Given Node node
        static class node {
            int key;
            node left, right;
        };

        // Function to create a new BST node
        static node newNode(int item)
        {
            node temp = new node();
            temp.key = item;
            temp.left = temp.right = null;
            return temp;
        }

        // Function to insert a new node with
        // given key in BST
        static node insert(node node, int key)
        {
            // If the tree is empty, return a new node
            if (node == null)
                return newNode(key);

            // Otherwise, recur down the tree
            if (key < node.key) {
                node.left = insert(node.left, key);
            }
            else if (key > node.key) {
                node.right = insert(node.right, key);
            }

            // Return the node
            return node;
        }

        // Function to print the right view
        // of a binary tree.
        static void rightViewUtil(node root, int level,
                                  int max_level)
        {
            // Base Case
            if (root == null)
                return;

            // If this is the last Node of its level
            if (max_level < level) {
                System.out.print(" " + root.key);
                max_level = level;
            }

            // Recur for right subtree

            rightViewUtil(root.right, level + 1, max_level);
        }

        // Wrapper over rightViewUtil()
        static void rightView(node root)
        {
            int max_level = 0;
            rightViewUtil(root, 1, max_level);
        }

        // Driver Code
        public static void main(String[] args)
        {

		/* Let us create following BST
				50
			/	 \
			30	 70
		/ \ / \
		20 40 60 80
	*/
            node root = null;

            // inserting value 50
            root = insert(root, 50);

            // inserting value 30
            insert(root, 30);

            // inserting value 20
            insert(root, 20);

            // inserting value 40
            insert(root, 40);

            // inserting value 70
            insert(root, 70);

            // inserting value 60
            insert(root, 60);

            // inserting value 80
            insert(root, 80);

            // print the BST
            rightView(root);
        }
    }
// This code is contributed by abhijitjadhav1998

//Output
//    50    70    80
//Time Complexity: O(N), where N is the number of nodes of the BST
//Auxiliary Space: O(1)
