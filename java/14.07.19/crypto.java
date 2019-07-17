import java.util.*;

public class crypto
{
    public static String uniqueString(String s1, String s2, String s3)
    {
        String ans = "";
        boolean[] takenNumber = new boolean[26];
        for(char ch: s1.toCharArray())
        {
            takenNumber[ch - 'a'] = true;
        }
        for(char ch: s2.toCharArray())
        {
            takenNumber[ch - 'a'] = true;
        }
        for(char ch: s3.toCharArray())
        {
            takenNumber[ch - 'a'] = true;
        }
        for(int i = 0; i < 26; i++)
        {
            if(takenNumber[i] == true)
            {
                ans += (char)(i + 'a');
            }
        }
        return ans;
    }

    public static int convertToNumber(String s, int[] map)
    {
        int sum = 0;
        int ten = 1;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            sum += ten * map[s.charAt(i) - 'a'];
            ten = ten*10;
        }
        return sum;
    }

    static int counter = 0;
    public static void getMapping(int[] map, String unique, boolean[] numberTaken, String s1, String s2, String s3)
    {
        if(unique.length() == 1)
        {
            int n1 = convertToNumber(s1, map);
            int n2 = convertToNumber(s2, map);
            int n3 = convertToNumber(s3, map);
            if(n1 + n2 == n3)
            {
                System.out.print(++counter + ". ");
                for(int i = 0; i < 26; i++)
                {
                    if(map[i] != -1)
                    {
                        System.out.print((char)(i + 'a') + "=" + map[i] +" ");
                    }
                }
                System.out.println();
                return;
            }
            return;
        }
        for(int i = 0; i < 10; i++)
        {
            char first = unique.charAt(0);
            String nextInput = unique.substring(1, unique.length());
            if(numberTaken[i] == false)
            {
                numberTaken[i] = true;
                map[first - 'a'] = i;
                getMapping(map, nextInput, numberTaken, s1, s2, s3);
                map[first - 'a'] = -1;
                numberTaken[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        String s3 = scn.next();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        String unique = uniqueString(s1, s2, s3);
        boolean[] numberTaken = new boolean[10];
        getMapping(map, unique, numberTaken, s1, s2, s3);
    }
}