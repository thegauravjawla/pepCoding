import java.util.*;

public class testImplementation{
    public static void main(String[] args) {
        myhm<String, Integer> frequencyMap = new myhm<>();
        frequencyMap.put("India", 100);
        frequencyMap.put("Pak", 0);
        frequencyMap.put("US", 110);
        frequencyMap.put("Nigeria", 60);
        frequencyMap.put("Etupia", 60);
        frequencyMap.put("HelloWorld", 60);
        frequencyMap.put("BS", 60);
        frequencyMap.put("Germany", 60);
        frequencyMap.put("Australia", 90);
        System.out.println("................................");
        frequencyMap.display();
        System.out.println("................................");
        frequencyMap.put("India", 200);
        frequencyMap.display();
        System.out.println("................................");
        System.out.println(frequencyMap.containsKey("India"));
        frequencyMap.remove("India");
        System.out.println(frequencyMap.get("India"));
        System.out.println(frequencyMap.keySet().toString());
        System.out.println(frequencyMap.containsKey("India"));
    }
}