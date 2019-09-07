import java.util.*;
public class tougleBit
{
    static int tougleBitOf(int n, int k){
        int mask = (1 << k);
        return mask^n;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(tougleBitOf(n, k));
    }
}