import java.util.*;

public class removeLeftDuplicate
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

    static Node removeDuplicate(Node root)
    {
        if(root.left != null)
        {
            if(root.left.left != null)
                root.left = removeDuplicate(root.left.left);
            else
                root.left = null;
        }
        if(root.right != null)
        {
            root.right = removeDuplicate(root.right);
        }
        return root;
    }

    public static void main(String[] args) 
    {
        int[] a = {10, 10, 20, 20, 30, 30, -1, -1, -1, -1, -1, 40, 40, 50, 50, -1, -1, -1, 60, 60, -1, -1, -1, -1};
        Node root = construct(a);

        root = removeDuplicate(root);
        display(root);
    }
}