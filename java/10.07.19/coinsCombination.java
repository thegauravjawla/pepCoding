import java.util.*;
public class coinsCombination
{
    public static void getCoins(int[] currency, int moneyToGive, String ans, int index)
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
        for(int i = index; i < currency.length; i++)    //here currency[i] is the item || and we only need ascending order.
        {
            getCoins(currency, moneyToGive - currency[i], ans + currency[i], index + i);
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
        Arrays.sort(currency);
        getCoins(currency, moneyToGive, "", 0);
    }
}