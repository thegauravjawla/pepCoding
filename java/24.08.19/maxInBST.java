import java.util.*;
public class maxInBST
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

    static int max(Node root)
    {
        int max = root.data;
        if(root.right != null)
        {
            max = max(root.right);
        }
        return max;
    }

    static int min(Node root)
    {
        int min = root.data;
        if(root.left != null)
        {
            min = min(root.left);
        }
        return min;
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        System.out.println(max(root));
        System.out.println(min(root));
    }
}