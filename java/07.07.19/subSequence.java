import java.util.*;
public class subSequence
{

    public static void seq(String s, String ans)
    {
        if(s.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char firstChar = s.charAt(0);
        String restString = s.substring(1, s.length());
        seq(restString, ans + firstChar);
        seq(restString, ans + "-");
    }
    public static void main(String[] argc)
    {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        seq(s, "");
    }
}