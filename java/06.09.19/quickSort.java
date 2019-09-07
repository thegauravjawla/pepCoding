import java.util.*;
public class quickSort{
    static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int lo, int hi){
        int highStart = 0;
        int pivot = a[hi];
        for(int i = 0; i <= hi; i++){
            if(a[i] <= pivot){
                swap(a, highStart, i);
                highStart++;
            }
        }
        //returns partitioning index
        return highStart-1; //pivot is present there
    }
    static void sort(int[] a, int lo, int hi){
        if(hi < lo) //base case
            return;

        int partitioningIndex = partition(a, lo, hi);
        //now partitioningIndex element is fixed
        sort(a, lo, partitioningIndex-1);
        sort(a, partitioningIndex+1, hi);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        sort(a, 0, a.length-1);
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}