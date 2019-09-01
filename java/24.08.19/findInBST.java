import java.util.*;
public class findInBST
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

    static boolean find(Node root, int data)
    {
        boolean found = false;
        if(root.data == data)   return true;
        else if(data > root.data)
        {
            if(root.right!=null)
                found = find(root.right, data);
            if(found)   return found;
        }
        else
        {
            if(root.left!=null)
                found = find(root.left, data);
            if(found)   return found;
        }
        return found;
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        int data = 37;
        System.out.println(find(root, data));
    }
}