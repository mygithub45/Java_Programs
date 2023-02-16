package LeetCode;// In java function tour() takes two arguments array of petrol
// and array of distance
//https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
//https://www.youtube.com/watch?v=zcnVaVJkLhY
//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
class PetrolCircularTourGasStation
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	int start=0;
	int deficit=0;
	int petrolremain=0;
	for(int i=0;i<petrol.length;i++){
	    petrolremain+=petrol[i]-distance[i];
	    if(petrolremain<0){
	        start=i+1;
	        deficit+=petrolremain;
	        petrolremain=0;
	    }
	}
	//petrolremain+deficit>0 means we can complete a cycle
	return (petrolremain+deficit)>0?start:-1;
	
	
    }
}