import java.util.*;
public class capDP
{
    static int f(ArrayList[] capWithPerson, boolean[] taken)
    {
        
        return 1;
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int person = scn.nextInt();
        int caps = scn.nextInt();
        ArrayList[] capWithPerson = new ArrayList[person];
        for(int i = 0; i < person; i++)
        {
            ArrayList<Integer> c = new ArrayList<>();
            int sc = scn.nextInt();
            while(sc != -1)
            {
                c.add(sc);
                sc = scn.nextInt();
            }
            capWithPerson[i] = c;
        }
        boolean[] taken = new boolean[caps+1];

        int noOfWays = f(capWithPerson, taken);
    }
}