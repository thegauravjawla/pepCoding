import java.util.*;

public class printSingleChild
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

    static void singleChild(Node root)
    {
        if(root.left != null)
        {
            singleChild(root.left);
            if(root.right == null)  System.out.print(root.left.data + " ");
        }
        if(root.right != null)
        {
            singleChild(root.right);
            if(root.left == null)  System.out.print(root.right.data + " ");
        }
    }

    public static void main(String[] args) 
    {
        int[] a = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, 33, -1, -1, 70, -1, -1, 87, -1, -1, -1}; //changed the tree and added 33 :)
        Node root = construct(a);

        singleChild(root);
    }
}