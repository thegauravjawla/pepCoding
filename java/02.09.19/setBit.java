import java.util.*;
public class setBit
{
    static int setBitOf(int n, int k){
        // int powerOf2 = 1;
        int mask = 1 << k;
        
        // while(k-->0)
        // {
        //     powerOf2 *= 2;
        // }
        return mask|n;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(setBitOf(n, k));
    }
}