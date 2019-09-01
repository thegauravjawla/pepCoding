import java.util.*;
public class addNode
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

    static Node add(Node root, int data)
    {
        if(root.data > data)
        {
            if(root.left != null)
                root.left = add(root.left, data);
            else
            {
                Node node = new Node();
                node.data = data;
                root.left = node;
            }
        }
        if(root.data < data)
        {
            if(root.right != null)
                root.right = add(root.right, data);
            else
            {
                Node node = new Node();
                node.data = data;
                root.left = node;
            }
        }
        return root;
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        display(root);
        root = add(root, 55);
        System.out.println("//////////////////");
        display(root);
    }
}