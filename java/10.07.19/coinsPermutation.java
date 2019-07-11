import java.util.*;
public class coinsPermutation
{
    public static void getCoins(int[] currency, int moneyToGive, String ans)
    {
        if(moneyToGive == 0)
        {
            System.out.println(ans);
            return;
        }
        if(moneyToGive < 0)
        {
            return;
        }
        for(int item: currency)
        {
            getCoins(currency, moneyToGive - item, ans + item);
        }
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int moneyToGive = scn.nextInt();
        int m = scn.nextInt();
        int[] currency = new int[m];
        for(int i = 0; i < m; i++)
        {
            currency[i] = scn.nextInt();
        }
        getCoins(currency, moneyToGive, "");
    }
}