package Programs;

//https://www.enjoyalgorithms.com/blog/move-all-the-zeroes-to-the-end/

public class MoveZeroesToEnd {

    //static int[] X ={0,3,5,9,0,0,23,0};
    static int[] X ={4,8,6,0,2,0,1,12,15,0,3,5,9,0,0,23,0};
    public static void main(String s[])
    {
        int j=0;
        int temp;
        for(int i=0;i<X.length;i++)
        {
            if(X[i]!=0)
            {
                temp=X[j];
                X[j]=X[i];
                X[i]=temp;
                j++;
            }
        }
        System.out.println("After moving zeroes to the end:");
        for(int i=0;i<X.length;i++)
        {
            System.out.print(X[i]+" ");
        }
    }

    //Space O(1)
    //Time O(n)
}
