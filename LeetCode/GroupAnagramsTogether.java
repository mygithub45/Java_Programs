package LeetCode;// Java code tp print all anagrams together
import java.util.ArrayList;
import java.util.HashMap;
//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
public class GroupAnagramsTogether {

	private static ArrayList<ArrayList<String> >
	solver(
		ArrayList<String> list)
	{

		// Inner hashmap counts frequency
		// of characters in a string.
		// Outer hashmap for if same
		// frequency characters are present in
		// in a string then it will add it to
		// the arraylist.
		HashMap<HashMap<Character, Integer>,
				ArrayList<String> >
			map = new HashMap<HashMap<Character, Integer>,
							ArrayList<String> >();
		for (String str : list) {
			HashMap<Character, Integer>
				tempMap = new HashMap<Character, Integer>();

			// Counting the frequency of the
			// characters present in a string
			for (int i = 0; i < str.length(); i++) {
				if (tempMap.containsKey(str.charAt(i))) {
					int x = tempMap.get(str.charAt(i));
					tempMap.put(str.charAt(i), ++x);
				}
				else {
					tempMap.put(str.charAt(i), 1);
				}
			}

			// If the same frequency of characters
			// are already present then add that
			// string into that arraylist otherwise
			// created a new arraylist and add that string
			if (map.containsKey(tempMap))
				map.get(tempMap).add(str);
			else {
				ArrayList<String>
					tempList = new ArrayList<String>();
				tempList.add(str);
				map.put(tempMap, tempList);
			}
		}

		// Stores the result in a arraylist
		ArrayList<ArrayList<String> >
			result = new ArrayList<>();
		for (HashMap<Character, Integer>
				temp : map.keySet())
			result.add(map.get(temp));
		return result;
	}

	// Drivers Method
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("cat");
		list.add("dog");
		list.add("ogd");
		list.add("god");
		list.add("atc");

		System.out.println(solver(list));
	}
}

// This code is contributed by Arijit Basu(ArijitXfx)
//Time Complexity: Let there be N-words and each word has a maximum of M characters. The upper bound is O(NM).
//Space Complexity: Let there be N-words and each word has maximum M characters, therefore max. storage space for each word with at max. M characters will be O(M), therefore for max N-words, it will be O(N*M). Therefore, the upper bound is O(NM).