import java.util.*;
public class subSequence
{
    static ArrayList<String> getss(String s)
    {
        //base case
        if(s.length() == 0)
        {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        //non base cases
        char first = s.charAt(0);   //first character from the string that is passed
        String nextInput = s.substring(1, s.length());  //the next input will be the string passed minus the first letter
        ArrayList<String> smallerList = getss(nextInput);   //recieving the list of subArrays that to which we will add "-" & "firstLetter"
        ArrayList<String> result = new ArrayList<>();   //list to store the output from adding "-"and "firstLetter"
        for(int i = 0; i < smallerList.size(); i++)
        {
            String temp = smallerList.get(i);
            result.add("-" + temp);
            result.add(first + temp);
        }
        return result;
    }
    public static void main(String[] argc)
    {
        ArrayList<String> list = getss("abcd");
        System.out.println(list);
    }
}