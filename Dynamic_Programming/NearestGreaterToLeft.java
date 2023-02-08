package Dynamic_Programming;
//https://www.callicoder.com/nearest-greater-to-left/
import java.util.Scanner;
import java.util.Stack;

public class NearestGreaterToLeft {
    private static int[] findNearestGreaterToLeftUsingStack(int[] a) {
        int n = a.length;
        int[] NGL = new int[n];

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {
            NGL[i] = -1;
            while(!s.empty()) {
                int top = s.peek();
                if(top > a[i]) {
                    NGL[i] = top;
                    break;
                } else {
                    s.pop();
                }
            }
            s.push(a[i]);
        }

        return NGL;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();

        int[] NGL = findNearestGreaterToLeftUsingStack(a);
        for(int i = 0; i < n; i++) {
            System.out.print(NGL[i] + " ");
        }
        System.out.println();

    }
}
//Time Complexity: O(n), The entire array (of size n) is scanned only once. Each of the stack’s n elements are pushed and popped exactly once.
//
//Space Complexity: O(n)