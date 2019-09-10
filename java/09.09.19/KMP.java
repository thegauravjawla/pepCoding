import java.util.*;
public class KMP{
    static int[] getLPS(String pat){
        int[] lps = new int[pat.length()];
        lps[0] = 0;

        int i = 1;  //lps itterator
        int lengthMatched = 0;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(lengthMatched)){
                lps[i] = lengthMatched+1;
                lengthMatched++;
                i++;
            }
            else{
                if(lengthMatched-1>=0){
                    lengthMatched = lps[lengthMatched-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    static void matchPattern(String src, String pat){
        int[] lps = getLPS(pat);
        int i = 0; //source itterator
        int j = 0; //pattern itterator

        while(i < src.length()){
            if(src.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length()){
                    System.out.println("Volla!! Found at " + (i-pat.length()));
                    j = lps[j-1];
                }
            }
            else{
                if(j-1>=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        matchPattern("jhfkjhdkjhkfjhdlakjhhelloaksdjfhaskjdfhhellokjasdhkjh", "hello");
    }
}