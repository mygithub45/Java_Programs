package LeetCode;// Java program to return title
// to result of excel sheet.
import java.lang.*;
//https://www.geeksforgeeks.org/find-excel-column-number-column-title/
class ExcelColumnNameToNumber
{

// Returns result when we pass title.
static int titleToNumber(String s)
{
	// This process is similar to
	// binary-to-decimal conversion
	int result = 0;
	for (int i = 0; i < s.length(); i++)
	{
		result *= 26;
		result += s.charAt(i) - 'A' + 1;
	}
	return result;
}
	
// Driver Code
public static void main (String[] args)
{
	System.out.print(titleToNumber("CDA"));
}
}

// This code is contributed
// by Akanksha Rai(Abby_akku)
//Time Complexity: O(n), where n is length of input string.
//Space Complexity: O(1).
//As no extra space is required.