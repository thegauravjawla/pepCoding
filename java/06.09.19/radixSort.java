import java.util.*;
public class radixSort{
    static int[] countSort(int[] unsorted, int place){
        int n = unsorted.length;
        int range = 10; //doing for range 10 only (0-9)
        int[] frequency = new int[range];

        //here we are sorting purely on the basis of the digits at the given place
        //so we are making the frequency matrix of only 0-9;

        //finding frequency
        for(int element: unsorted){
            element = element/place%10;
            frequency[element]++;
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
            int index = --lastPosition[element/place%10];
            sorted[index] = element;
        }

        return sorted;
    }

    static int[] radixSort(int[] unsorted){
        int max = -1;
        for(int i = 0; i < unsorted.length; i++){
            if(max < unsorted[i]){
                max = unsorted[i];
            }
        }

        int place = 1;
        while(max/place > 0){
            unsorted = countSort(unsorted, place);
            place*=10;
        }

        return unsorted;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        a = radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}