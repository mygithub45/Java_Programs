package LeetCode;// Java program to find circular tour for a truck

//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
class GasStationPetrolPumpCircularTour {

// A petrol pump has petrol and distance to next petrol pump
static class petrolPump {

	int petrol;
	int distance;

	petrolPump(int a, int b) {
	this.petrol = a;
	this.distance = b;
	}
};

// The function returns starting point if there is a
// possible solution, otherwise returns -1
static int printTour(petrolPump p[], int n)
{

	// deficit is used to store the value of the capacity as
	// soon as the value of capacity becomes negative so as
	// not to traverse the array twice in order to get the
	// solution
	int start = 0, deficit = 0;
	int capacity = 0;
	for (int i = 0; i < n; i++) {
	capacity += p[i].petrol - p[i].distance;
	if (capacity < 0) {
		// If this particular step is not done then the
		// between steps would be redundant
		start = i + 1;
		deficit += capacity;
		capacity = 0;
	}
	}
	return (capacity + deficit >= 0) ? start : -1;
}

// Driver code
public static void main(String[] args) {
	petrolPump arr[] = { new petrolPump(6, 4),
						new petrolPump(3, 6),
						new petrolPump(7, 3) };

	int n = arr.length;
	int start = printTour(arr, n);

	if (start == -1)
	System.out.print("No solution");
	else
	System.out.print("Start = " + start);

}
}

// This code is contributed by umadevi9616
//Time Complexity: O(N)
//Auxiliary Space: O(1) 