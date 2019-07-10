import java.util.*;
public class nokia
{
    static String[] codes = {".", "abc", "def", "ghi", "jklm", "no", "pqrs", "tu", "vwxy", "z"};
    public static void step(String n, String ans)
    {
        if(n.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        char firstChar = n.charAt(0);
        String restOfN = n.substring(1, n.length());
        String code = codes[firstChar - '0'];
        for(int i = 0; i < code.length(); i++)
        {
            step(restOfN, ans + code.charAt(i));
        }
        return;
    }

    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        String n = scn.nextLine();
        step(n, "");
    }
}