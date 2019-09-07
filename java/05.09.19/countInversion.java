import java.util.*;
public class countInversion{
    static int inversions = 0;
    static int[] merge(int[] a, int[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[a.length+b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                result[k++] = a[i++];
            }
            else if(a[i] > b[j]){
                result[k++] = b[j++];
                inversions+=a.length-i;
            }
        }
        while(i < a.length){
            result[k++] = a[i++];
        }
        while(j < b.length){
            result[k++] = b[j++];
        }
        return result;
    }
    public static int[] mergeSort(int[] a, int lo, int hi){
        if(hi==lo){
            int[] base = new int[1];
            base[0] = a[lo];
            return base;
        }

        int mid = (hi+lo)/2;
        int[] left = mergeSort(a, lo, mid);
        int[] right = mergeSort(a, mid+1, hi);
        int[] result = merge(left, right);
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        int[] sorted = mergeSort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sorted));
        System.out.println(inversions);
    }
}