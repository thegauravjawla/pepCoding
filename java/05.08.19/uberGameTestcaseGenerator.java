import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class uberGameTestcaseGenerator
{
    public static void main(String[] args) throws FileNotFoundException
    {
        PrintStream o = new PrintStream(new File("uberGameIn.txt"));
        System.setOut(o);
        Random rand = new Random();
        int t = 20;
        System.out.println(t);
        for(int i = 0; i < t; i++)
        {
            int l =1 + rand.nextInt(30);
            System.out.println(l);
            for(int j = 0; j < l; j++)
            {
                int n = 1 + rand.nextInt(10);
                System.out.print(n + " ");
            }
        }
    }
}