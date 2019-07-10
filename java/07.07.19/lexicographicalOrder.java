import java.util.*;
public class lexicographicalOrder
{
    public static void getAns(int digits, String ans)
    {
        if(digits == ans.length())
        {
            if(ans == "0")
            {
    
            }
            else
            {
                System.out.println(ans);
            }
            return;
        }
        if(ans == "0")
        {

        }
        else
        {
            System.out.println(ans);
        }
        for(int i = 0; i < 10; i++)
        {
            getAns(digits, ans + i);
        }
        return;
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int noOfDigit = 0;
        while(n != 0)
        {
            n = n/10;
            noOfDigit++;
        }
        getAns(noOfDigit - 1, "");
    }
}
