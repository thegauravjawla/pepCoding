import java.util.*;
public class addRepetition
{
    public static void add(ArrayList <Integer> a)
    {
        int sum = 0;
        for(int i = a.size() - 2; i >= 0; i--)
        {
            if(a.get(i) == a.get(i + 1))
            {
                int val = a.remove(i + 1);
                sum += val;
            }
            else
            {
                int val = a.get(i + 1);
                sum+= val;
                a.set(i + 1, sum);
                sum = 0;
            }
        }
        int val = a.get(0);
        sum += val;
        a.set(0, sum);
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

        add(a);

        for(int i = 0; i < a.size(); i++)
        {
            System.out.print(a.get(i) + " ");
        }
    }
}