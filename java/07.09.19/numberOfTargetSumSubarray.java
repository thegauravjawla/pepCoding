import java.util.*;
public class numberOfTargetSumSubarray{
    static int getCount(int[] a, int target){
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(prefixSum, 1);
        for(int i: a){
            prefixSum+=i;

            if(frequencyMap.containsKey(prefixSum-target)){
                count+=frequencyMap.get(prefixSum-target);
            }

            if(frequencyMap.containsKey(prefixSum)){
                frequencyMap.put(prefixSum, frequencyMap.get(prefixSum)+1);
            }
            else{
                frequencyMap.put(prefixSum, 1);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }
        int target = scn.nextInt();

        int ans = getCount(a, target);
        System.out.println(ans);
    }
}