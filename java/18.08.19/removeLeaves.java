import java.util.*;

public class removeLeaves
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] a)
    {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == -1)
            {
                stack.pop();
            }
            else
            {
                Node node = new Node();
                node.data = a[i];
                if(stack.size() == 0)
                {
                    root = node;
                }
                else
                {
                    if(stack.peek().left == null)
                    {
                        stack.peek().left = node;
                    }
                    else
                    {
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            }
        }

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

    static void removeLeaf(Node root)
    {
        if(root.left != null)
        {
            if(root.left.left == null && root.left.right == null)
            {
                root.left = null;
            }
            else
            {
                removeLeaf(root.left);
            }
        }
        if(root.right != null)
        {
            if(root.right.left == null && root.right.right == null)
            {
                root.right = null;
            }
            else
            {
                removeLeaf(root.right);
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] a = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};
        Node root = construct(a);
        
        display(root);
        System.out.println("//////////////////////////");
        removeLeaf(root);
        display(root);
    }
}