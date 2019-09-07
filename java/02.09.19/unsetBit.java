import java.util.*;
public class unsetBit
{
    static int unsetBitOf(int n, int k){
        int mask = (1 << k);
        return mask&n;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(unsetBitOf(n, k));
    }
}