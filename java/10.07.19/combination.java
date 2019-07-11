import java.util.*;
public class combination
{
    public static void placement(boolean[] boxes, int toPlace, int objectsLeft, String ans, int index)
    {
        if(objectsLeft == 0)
        {
            System.out.println(ans);
            return;
        }
        for(int i = index; i < boxes.length; i++)
        {
            placement(boxes, toPlace + 1, objectsLeft - 1, ans + " " + "O" + toPlace + " -> " + "B" + i, index + i + 1);
        }
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[] boxes = new boolean[n];
        int objects = scn.nextInt();
        placement(boxes, 1, objects, "", 0);
    }
}