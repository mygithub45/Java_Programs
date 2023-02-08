package Dynamic_Programming;

import java.util.Scanner;
import java.util.Stack;
//https://www.callicoder.com/nearest-greater-to-right/
class NearestGreaterToRight {
    private static int[] nextGreaterElementUsingStack(int[] a) {
        int n = a.length;
        int[] NGR = new int[n];

        Stack<Integer> s = new Stack<Integer>();
        for(int i = n-1; i >= 0; i--) {
            NGR[i] = -1;
            while(!s.empty()) {
                int top = s.peek();
                if (top > a[i]) {
                    NGR[i] = top;
                    break;
                } else {
                    s.pop();
                }
            }
            s.push(a[i]);
        }

        return NGR;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();

        int[] NGR = nextGreaterElementUsingStack(a);
        for(int i = 0; i < n; i++) {
            System.out.print(NGR[i] + " ");
        }
        System.out.println();
    }
}
//Time Complexity: O(n), The entire array (of size n) is scanned only once. Each of the stack’s n elements are pushed and popped exactly once.
//
//Space Complexity: O(n)