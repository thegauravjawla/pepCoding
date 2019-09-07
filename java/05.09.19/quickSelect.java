import java.util.*;
public class quickSelect{
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
        return highStart-1;
    }
    static int quickSelect(int[] a, int lo, int hi, int k){
        int partitioningIndex = partition(a, lo, hi);
        if(partitioningIndex == k){
            return a[partitioningIndex];
        }
        else if(partitioningIndex > k){
            return quickSelect(a, lo, partitioningIndex-1, k);
        }
        else{
            return quickSelect(a, partitioningIndex+1, hi, k);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        int k = scn.nextInt()-1;

        int res = quickSelect(a, 0, a.length-1, k);
        System.out.println(res);
    }
}