import java.util.*;
public class found
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

    static boolean found(Node root, int data)
    {
        if(root.data == data)   return true;

        if(root.left != null)
        {
            if(found(root.left, data)==true)    return true;
        }
        if(root.right != null)
        {
            if(found(root.right, data)==true)    return true;
        }
        return false;
    }

    public static void main(String[] args) 
    {
        int[] a = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};
        Node root = construct(a);
        
        int data = 37;
        boolean ans = found(root, data);
        System.out.println(ans);
    }
}