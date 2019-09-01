import java.util.*;
public class targetSumPair2
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] a, int i, int j)
    {
        if(i == j)
        {
            Node root = new Node();
            root.data = a[i];
            return root;
        }
        Node root = new Node();
        root.data = a[(j+i)/2];
        root.left = construct(a, i, ((j+i)/2)-1);
        root.right = construct(a, ((j+i)/2)+1, j);
        return root;
    }

    static void getSortedArray(Node root, ArrayList<Integer> v)
    {
        if(root.left != null)
            getSortedArray(root.left, v);

        v.add(root.data);

        if(root.right != null)
            getSortedArray(root.right, v);
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        ArrayList<Integer> v = new ArrayList<>();
        getSortedArray(root, v);

        int target = 75;
        int i = 0, j = v.size()-1;
        while(i < j)
        {
            if(v.get(i) + v.get(j) == target)
            {
                System.out.println(v.get(i) + " + " + v.get(j));
                i++;j--;
            }
            else if(v.get(i) + v.get(j) > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
    }
}