package LeetCode;// Java program to find maximum rectangular area in linear
// time
//https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
import java.util.Stack;
//Create an empty stack.
//Start from the first bar, and do the following for every bar hist[i] where ‘i‘ varies from 0 to n-1
//If the stack is empty or hist[i] is higher than the bar at top of the stack, then push ‘i‘ to stack.
//If this bar is smaller than the top of the stack, then keep removing the top of the stack while the top of the stack is greater.
//Let the removed bar be hist[tp]. Calculate the area of the rectangle with hist[tp] as the smallest bar.
//For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i‘ (current index).
//If the stack is not empty, then one by one remove all bars from the stack and do step (2.2 and 2.3) for every removed bar
public class MaxAreaHistoGram {
	// The main function to find the maximum rectangular
	// area under given histogram with n bars
	static int getMaxArea(int hist[], int n)
	{
		// Create an empty stack. The stack holds indexes of
		// hist[] array The bars stored in stack are always
		// in increasing order of their heights.
		Stack<Integer> s = new Stack<>();

		int max_area = 0; // Initialize max area
		int tp; // To store top of stack
		int area_with_top; // To store area with top bar as
						// the smallest bar

		// Run through all bars of given histogram
		int i = 0;
		while (i < n) {
			// If this bar is higher than the bar on top
			// stack, push it to stack
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			// If this bar is lower than top of stack, then
			// calculate area of rectangle with stack top as
			// the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before
			// top in stack is 'left index'
			else {
				tp = s.peek(); // store the top index
				s.pop(); // pop the top

				// Calculate the area with hist[tp] stack as
				// smallest bar
				area_with_top
					= hist[tp]
					* (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		// Now pop the remaining bars from stack and
		// calculate area with every popped bar as the
		// smallest bar
		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top
				= hist[tp]
				* (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;
	}

	// Driver code
	public static void main(String[] args)
	{
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };

		// Function call
		System.out.println("Maximum area is "
						+ getMaxArea(hist, hist.length));
	}
}
// Time Complexity: O(N)
//Auxiliary Space: O(N)
