import java.util.*;
public class countSort{
    static int[] countSort(int[] unsorted){
        int n = unsorted.length;
        int range = 10; //doing for range 10 only (0-9)
        int[] frequency = new int[range];

        //finding frequency
        for(int val: unsorted){
            frequency[val]++;
        }

        //dp step
        for(int i = 1; i < range; i++){
            frequency[i] += frequency[i-1];
        }
        int[] lastPosition = frequency; //changing name

        int[] sorted = new int[n];
        //reverse traverse
        for(int i = n-1; i>=0; i--){
            int element = unsorted[i];
            int index = --lastPosition[element];
            sorted[index] = element;
        }

        return sorted;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        a = countSort(a);
        System.out.println(Arrays.toString(a));
    }
}