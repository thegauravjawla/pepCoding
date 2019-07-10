import java.util.*;
public class binarySearch
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scn.nextInt();
        }
        Arrays.sort(a);
        int data = scn.nextInt();
        int l = 0;  //left pointer in the form of index
        int r = a.length - 1;   //right index
        
        while(l <= r)
        {
            int mid = (l + r)/2;

            if (data > a[mid])
            {
                l = mid + 1;
            }
            else if(data < a[mid])
            {
                r = mid - 1;
            }
            else
            {
                System.out.println("index of " + data + " is " + mid);
                return;
            }
        }
        System.out.println("Not found");
    }
}