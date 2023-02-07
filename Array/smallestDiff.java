package Array;

import java.util.Arrays;

public class smallestDiff {
    public static int[] findSmallestDifferencePair(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);

        double smallestDiff = Double.MAX_VALUE;
        int[] smallestDiffPair = new int[2];
        int i = 0, j = 0;

        while(i < a1.length && j < a2.length) {
            double currentDiff = Math.abs(a1[i] - a2[j]);
            if(currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestDiffPair[0] = a1[i];
                smallestDiffPair[1] = a2[j];
            }
            if(a1[i] < a2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return smallestDiffPair;
    }
    public static void main(String[] args) {
        int[] a1 = new int[] {-1, 5, 10, 20, 28, 3};
        int[] a2 = new int[] {26, 134, 135, 15, 17};

        int[] pair = findSmallestDifferencePair(a1, a2);
        System.out.println(pair[0] + " " + pair[1]);
    }
}
