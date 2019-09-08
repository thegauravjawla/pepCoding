import java.util.*;
public class maxFrequencyAlphabet{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < 26; i++){
            Character ch = (char)(i+'a');
            frequencyMap.put(ch, 0);
        }

        String s = scn.next();

        Character max = 'a';
        for(Character ch: s.toCharArray()){
            int f = frequencyMap.get(ch) + 1;
            frequencyMap.put(ch, f);

            if(frequencyMap.get(max) < f){
                max = ch;
            }
        }

        System.out.println(max);
    }
}