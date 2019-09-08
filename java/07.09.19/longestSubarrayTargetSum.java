import java.util.*;
public class longestSubarrayTargetSum{
    static int longestSubarray(int[] a, int target){
        int prefixSum = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(prefixSum, -1);
        for(int i = 0; i < a.length; i++){
            prefixSum+=a[i];

            if(frequencyMap.containsKey(prefixSum-target)){
                int len = frequencyMap.get(prefixSum) - frequencyMap.get(prefixSum-target);
                if(maxLen < len){
                    maxLen = len;
                }
            }

            if(!frequencyMap.containsKey(prefixSum)){
                frequencyMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        
    }
}