import java.util.*;
public class binarySmallestIndex
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

        int flag = -1;   //because the index can never be negative
                         //As soon as the number is found, flag is equal to its index and hence it is definitely not -1

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
                flag = mid;
                r = mid - 1;
            }
        }
        if(flag == -1)
        {
            System.out.println("Not found");
        }    
        else
        {
            System.out.println("It is present at index " + flag);
        }
    }
}

//for binarySearch of the Largest Index


// import java.util.*;
// public class binarySmallestIndex
// {
//     public static void main(String[] args) 
//     {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] a = new int[n];
//         for(int i = 0; i < n; i++)
//         {
//             a[i] = scn.nextInt();
//         }
//         Arrays.sort(a);
//         int data = scn.nextInt();
//         int l = 0;  //left pointer in the form of index
//         int r = a.length - 1;   //right index

//         int flag = -1;   //because the index can never be negative
//                          //As soon as the number is found, flag is equal to its index and hence it is definitely not -1

//         while(l <= r)
//         {
//             int mid = (l + r)/2;

//             if (data > a[mid])
//             {
//                 l = mid + 1;
//             }
//             else if(data < a[mid])
//             {
//                 r = mid - 1;
//             }
//             else
//             {
//                 flag = mid;
//                 l = mid + 1;
//             }
//         }
//         if(flag == -1)
//         {
//             System.out.println("Not found");
//         }    
//         else
//         {
//             System.out.println("It is present at index " + flag);
//         }
//     }
// }