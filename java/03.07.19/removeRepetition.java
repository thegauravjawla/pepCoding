import java.util.*;
public class removeRepetition
{
    public static void remove(ArrayList <Integer> a)
    {
        for(int i = a.size() - 2; i >= 0; i--)
        {
            if(a.get(i) == a.get(i + 1))
            {
                a.remove(i + 1);
            }
        }
    }
    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList <Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int temp = scn.nextInt();
            a.add(temp);
        }

        remove(a);

        for(int i = 0; i < a.size(); i++)
        {
            System.out.print(a.get(i) + " ");
        }
    }
}