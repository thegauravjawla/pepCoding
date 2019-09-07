import java.util.*;
public class alphabetCount{
    static int[] hash(String s){
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            map[ch-'a']++;
        }
        return map;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int[] hashmap = hash(s);

        int max = 0;
        for(int i = 0; i < hashmap.length; i++)
        {
            if(hashmap[max] < hashmap[i])
                max = i;
        }
        Character ch = (char)(max+'a');
        System.out.println(ch);
    }
}