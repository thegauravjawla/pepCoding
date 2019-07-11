import java.util.*;
public class permutation
{
    public static void placement(boolean[] boxes, int toPlace, int objectsLeft, String ans)
    {
        if(objectsLeft == 0)
        {
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < boxes.length; i++)
        {
            if(boxes[i] == false)
            {
                boxes[i] = true;
                placement(boxes, toPlace + 1, objectsLeft - 1, ans + " " + "O" + toPlace + " in " + "B" + i);
                boxes[i] = false;
            }
        }
        return;
    }
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[] boxes = new boolean[n];
        int objects = scn.nextInt();
        placement(boxes, 1, objects, "");
    }
}