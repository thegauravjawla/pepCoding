import java.util.*;
public class rotate
{
    public static void printRotate(ArrayList <Integer> a, int k)
    {
        int addTo = 0;
        for(int i = 0; i < k; i++)
        {
            a.add(addTo, a.get(a.size() - 1));
            a.remove(a.size() - 1);
            addTo++;
        }

    }
    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList <Integer> a = new ArrayList<>();  //dexlare an array list

        //adding elements
        for(int i = 0; i < n; i++)
        {
            int temp = scn.nextInt();
            a.add(temp);
        }

        int k = scn.nextInt();
        printRotate(a, k);
        for(int i = 0; i < a.size(); i++)
        {
            System.out.print(a.get(i) + " ");
        }
    }
}