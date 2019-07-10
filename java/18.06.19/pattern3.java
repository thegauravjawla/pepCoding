import java.util.*;
public class pattern3
{
    public static void main(String[] argv)
    {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int nSpaces = n/2;
        int nStars = 1;
        int val = 1;
        int ii = 1;
        for (int i = 1; i <= n; i++)
        {
            for(int j = 0; j < nSpaces; j++)
            {
                System.out.print("  ");
            }
            val = ii;
            for(int j = 1; j <= nStars; j++)
            {
                System.out.print(val + " ");
                if(j <= nStars/2)
                {
                    val++;
                }
                else
                {
                    val--;
                }
            }            
            if(i <= n/2)
            {
                nStars += 2;
                nSpaces--;
                ii++;
            }
            else
            {   
                ii--;
                nStars -= 2;
                nSpaces++;
            }
            System.out.println();
        }
    }
}

// import java.util.*;
// public class pattern3
// {
//     public static void main(String[] argv)
//     {
//         int n;
//         Scanner scn = new Scanner(System.in);
//         n = scn.nextInt();
//         int nSpaces = n/2;
//         int nStars = 1;
//         int val = 1;
//         int ii = 1;
//         for (int i = 1; i <= n; i++)
//         {
//             for(int j = 0; j < nSpaces; j++)
//             {
//                 System.out.print("  ");
//             }
//             val = ii;
//             for(int j = 1; j <= nStars; j++)
//             {
//                 System.out.print(val + " ");
//                 val++;
//             }            
//             if(i <= n/2)
//             {
//                 nStars += 2;
//                 nSpaces--;
//                 ii++;
//             }
//             else
//             {   
//                 ii--;
//                 nStars -= 2;
//                 nSpaces++;
//             }
//             System.out.println();
//         }
//     }
// }


// import java.util.*;
// public class pattern3
// {
//     public static void main(String[] argv)
//     {
//         int n;
//         Scanner scn = new Scanner(System.in);
//         n = scn.nextInt();
//         int nSpaces = n/2;
//         int nStars = 1;
//         int val = 1;
//         for (int i = 1; i <= n; i++)
//         {
//             for(int j = 0; j < nSpaces; j++)
//             {
//                 System.out.print("  ");
//             }
//             for(int j = 0; j < nStars; j++)
//             {
//                 System.out.print(val + " ");
//             }            
//             if(i <= n/2)
//             {
//                 nStars += 2;
//                 nSpaces--;
//                 val++;
//             }
//             else
//             {
//                 val--;
//                 nStars -= 2;
//                 nSpaces++;
//             }
//             System.out.println();
//         }
//     }
// }


// import java.util.*;
// public class pattern3
// {
//     public static void main(String[] argv)
//     {
//         int n;
//         Scanner scn = new Scanner(System.in);
//         n = scn.nextInt();
//         int nSpaces = n/2;
//         int nStars = 1;
//         int val = 1;
//         for (int i = 1; i <= n; i++)
//         {
//             for(int j = 0; j < nSpaces; j++)
//             {
//                 System.out.print("  ");
//             }
//             for(int j = 0; j < nStars; j++)
//             {
//                 System.out.print(val + " ");
//             }            
//             if(i <= n/2)
//             {
//                 nStars += 2;
//                 nSpaces--;
//             }
//             else
//             {
//                 nStars -= 2;
//                 nSpaces++;
//             }
//             System.out.println();
//             val++;
//         }
//     }
// }




// import java.util.*;
// public class pattern3
// {
//     public static void main(String[] argv)
//     {
//         int n;
//         Scanner scn = new Scanner(System.in);
//         n = scn.nextInt();
//         int nSpaces = n/2;
//         int nStars = 1;
//         for (int i = 1; i <= n; i++)
//         {
//             for(int j = 0; j < nSpaces; j++)
//             {
//                 System.out.print("   ");
//             }
//             for(int j = 0; j < nStars; j++)
//             {
//                 System.out.print(" * ");
//             }            
//             if(i <= n/2)
//             {
//                 nStars += 2;
//                 nSpaces--;
//             }
//             else
//             {
//                 nStars -= 2;
//                 nSpaces++;
//             }
//             System.out.println();
//         }
//     }
// }