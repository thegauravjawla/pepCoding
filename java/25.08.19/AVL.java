import java.util.*;
public class AVL
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        int bf;
        int height;
    }

    static int height(Node root)
    {
        int leftHeight = root.left!=null? height(root.left):0;
        int rightHeight = root.right!=null? height(root.right):0;

        return Math.max(leftHeight, rightHeight)+1;
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
        root.height = height(root);
        root.bf = height(root.left) - height(root.right);
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


    static Node leftRotate(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        y.left = x;

        x.height = height(x);
        y.height = height(y);
        x.bf = height(x.left)-height(x.right);
        return y;
    }

    static Node rightRotate(Node x)
    {
        Node y = x.left;
        x.left = y.right;
        y.right = x;

        x.height = height(x);
        y.height = height(y);
        x.bf = height(x.left)-height(x.right);
        return y;
    }

    static Node add(Node root, int data)
    {
        if(root.data > data)
        {
            if(root.left != null)
            {
                root.left = add(root.left, data);
                root.height = height(root) + 1;
                root.bf = height(root.left) - (root.right!=null?height(root.right):0);
            }
            else
            {
                Node node = new Node();
                node.data = data;
                root.left = node;
                root.bf = 0;
                root.height = 1;
            }
        }
        if(root.data < data)
        {
            if(root.right != null)
            {
                root.right = add(root.right, data);
                root.height = height(root) + 1;
                root.bf = (root.left!=null?height(root.left):0) - height(root.right);
            }
            else
            {
                Node node = new Node();
                node.data = data;
                root.left = node;
                root.bf = 0;
                root.height = 1;
            }
        }

        if(root.bf > 1)
        {
            if(root.left.bf >= 0)
            {
                //ll
                root = leftRotate(root);
            }
            else
            {
                //lr
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        else if(root.bf < -1)
        {
            if(root.right.bf <= 0)
            {
                //rr
                root = leftRotate(root);
            }
            else
            {
                //rl
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }

        return root;
    }

    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        display(root);
        add(root, 30);
        add(root, 28);
        // add(root, 29);
        System.out.println("////////////");
        display(root);
    }
}