import java.util.*;
public class commonElements{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<Integer, Integer> frequencyMap1 = new HashMap<>();

        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            int x = scn.nextInt();
            if(frequencyMap1.containsKey(x))
                frequencyMap1.put(x, frequencyMap1.get(x)+1);
            else
                frequencyMap1.put(x, 1);
        }

        HashMap<Integer, Integer> frequencyMap2 = new HashMap<>();

        n = scn.nextInt();
        for(int i = 0; i < n; i++){
            int x = scn.nextInt();
            if(frequencyMap2.containsKey(x))
                frequencyMap2.put(x, frequencyMap2.get(x)+1);
            else
                frequencyMap2.put(x, 1);
        }

        for(int i: frequencyMap1.keySet()){
            if(frequencyMap2.containsKey(i)){
                int f = Math.min(frequencyMap1.get(i), frequencyMap2.get(i));
                for(int j = 0; j < f; j++){
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }
}