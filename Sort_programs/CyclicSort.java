import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2,6,8,10,12,11,9,7};
        // starting time
        long start = System.currentTimeMillis();

        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        // ending time
        long end = System.currentTimeMillis();
        System.out.println("time taken " +
                (end - start) + "ms");
    }
    static void cyclicSort(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            int correctIndex=arr[i]-1;
            if(arr[i] != arr[correctIndex])
            {
                swap(arr,i,correctIndex);
            }
            else {
                i++;
            }
        }
    }
    static void swap(int[] arr,int i,int correctIndex)
    {
        int tmp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=tmp;
    }
}
