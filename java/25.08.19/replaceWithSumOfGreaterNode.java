import java.util.*;
public class replaceWithSumOfGreaterNode
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

    static void display(Node root)
    {
        String str = new String();
        str+=root.left!=null?root.left.data + " -> ":". -> ";
        str+=root.data;
        str+=root.right!=null? " <- " +root.right.data:" <- .";
        System.out.println(str);

        if(root.left!=null)
            display(root.left);
        if(root.right!=null)
            display(root.right);

        return;
    }

    static int max = 0;
    static void transform(Node root)
    {
        if(root.right != null)
            transform(root.right);

        int rootData = root.data;
        root.data = max;
        max+=rootData;
        
        if(root.left != null)
            transform(root.left);
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        display(root);
        transform(root);
        System.out.println("//////////////////");
        display(root);
    }
}