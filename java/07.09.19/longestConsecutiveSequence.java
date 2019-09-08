import java.util.*;
public class longestConsecutiveSequence{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<Integer, Boolean> map = new HashMap<>();

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int x = scn.nextInt();
            arr[i] = x;
            map.put(x, true);
        }

        for(int i: map.keySet()){
            if(map.containsKey(i-1)){
                map.put(i, false);
            }
        }

        int maxStart = -1;
        int maxLen = 0;
        for(int i: map.keySet()){
            if(map.get(i) == true){
                int len = 1;
                while(map.containsKey(i+len)){
                    len++;
                }
                if(len > maxLen){
                    maxStart = i;
                    maxLen = len;
                }
            }
        }

        for(int i = maxStart; i < maxStart+maxLen; i++)
        {
            System.out.print(i + " ");
        }
    }
}